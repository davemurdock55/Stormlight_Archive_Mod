package net.mcreator.stormlightmod;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class StormlightModModVariables {
	public StormlightModModVariables(StormlightModModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "stormlight_mod_worldvars";
		public double bromeStormlightAmount = 6000.0;
		public double markStormlightAmount = 3000.0;
		public double chipStormlightAmount = 1500.0;
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			bromeStormlightAmount = nbt.getDouble("bromeStormlightAmount");
			markStormlightAmount = nbt.getDouble("markStormlightAmount");
			chipStormlightAmount = nbt.getDouble("chipStormlightAmount");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("bromeStormlightAmount", bromeStormlightAmount);
			nbt.putDouble("markStormlightAmount", markStormlightAmount);
			nbt.putDouble("chipStormlightAmount", chipStormlightAmount);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (!world.getWorld().isRemote)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.getWorld().dimension::getType),
						new WorldSavedDataSyncMessage(1, this));
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(IWorld world) {
			if (world.getWorld() instanceof ServerWorld) {
				return ((ServerWorld) world.getWorld()).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "stormlight_mod_mapvars";
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (!world.getWorld().isRemote)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(IWorld world) {
			if (world.getWorld() instanceof ServerWorld) {
				return world.getWorld().getServer().getWorld(DimensionType.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("stormlight_mod", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("lashingAmount", instance.lashingAmount);
			nbt.putDouble("stormlightConsumedAmnt", instance.stormlightConsumedAmnt);
			nbt.putDouble("radiantLevel", instance.radiantLevel);
			nbt.put("sphereTypeInfused", instance.sphereTypeInfused.write(new CompoundNBT()));
			nbt.putBoolean("radiantTrueFalse", instance.radiantTrueFalse);
			nbt.put("sphereTypeDun", instance.sphereTypeDun.write(new CompoundNBT()));
			nbt.putBoolean("truthwatcherSprenSpawned", instance.truthwatcherSprenSpawned);
			nbt.putBoolean("honorSprenSpawned", instance.honorSprenSpawned);
			nbt.putBoolean("highSprenSpawned", instance.highSprenSpawned);
			nbt.putBoolean("ashSprenSpawned", instance.ashSprenSpawned);
			nbt.putBoolean("cultivationSprenSpawned", instance.cultivationSprenSpawned);
			nbt.putBoolean("crypticSprenSpawned", instance.crypticSprenSpawned);
			nbt.putBoolean("inkSprenSpawned", instance.inkSprenSpawned);
			nbt.putBoolean("lightSprenSpawned", instance.lightSprenSpawned);
			nbt.putBoolean("stonewardSprenSpawned", instance.stonewardSprenSpawned);
			nbt.putBoolean("bondsmithSprenSpawned", instance.bondsmithSprenSpawned);
			nbt.putDouble("truthwatcherSprenVar", instance.truthwatcherSprenVar);
			nbt.putDouble("bondAmount", instance.bondAmount);
			nbt.putDouble("radiant2Level", instance.radiant2Level);
			nbt.putBoolean("receivedSprenblade", instance.receivedSprenblade);
			nbt.putDouble("lastInfusionAmnt", instance.lastInfusionAmnt);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.lashingAmount = nbt.getDouble("lashingAmount");
			instance.stormlightConsumedAmnt = nbt.getDouble("stormlightConsumedAmnt");
			instance.radiantLevel = nbt.getDouble("radiantLevel");
			instance.sphereTypeInfused = ItemStack.read(nbt.getCompound("sphereTypeInfused"));
			instance.radiantTrueFalse = nbt.getBoolean("radiantTrueFalse");
			instance.sphereTypeDun = ItemStack.read(nbt.getCompound("sphereTypeDun"));
			instance.truthwatcherSprenSpawned = nbt.getBoolean("truthwatcherSprenSpawned");
			instance.honorSprenSpawned = nbt.getBoolean("honorSprenSpawned");
			instance.highSprenSpawned = nbt.getBoolean("highSprenSpawned");
			instance.ashSprenSpawned = nbt.getBoolean("ashSprenSpawned");
			instance.cultivationSprenSpawned = nbt.getBoolean("cultivationSprenSpawned");
			instance.crypticSprenSpawned = nbt.getBoolean("crypticSprenSpawned");
			instance.inkSprenSpawned = nbt.getBoolean("inkSprenSpawned");
			instance.lightSprenSpawned = nbt.getBoolean("lightSprenSpawned");
			instance.stonewardSprenSpawned = nbt.getBoolean("stonewardSprenSpawned");
			instance.bondsmithSprenSpawned = nbt.getBoolean("bondsmithSprenSpawned");
			instance.truthwatcherSprenVar = nbt.getDouble("truthwatcherSprenVar");
			instance.bondAmount = nbt.getDouble("bondAmount");
			instance.radiant2Level = nbt.getDouble("radiant2Level");
			instance.receivedSprenblade = nbt.getBoolean("receivedSprenblade");
			instance.lastInfusionAmnt = nbt.getDouble("lastInfusionAmnt");
		}
	}

	public static class PlayerVariables {
		public double lashingAmount = 1.0;
		public double stormlightConsumedAmnt = 0;
		public double radiantLevel = 0;
		public ItemStack sphereTypeInfused = ItemStack.EMPTY;
		public boolean radiantTrueFalse = false;
		public ItemStack sphereTypeDun = ItemStack.EMPTY;
		public boolean truthwatcherSprenSpawned = false;
		public boolean honorSprenSpawned = false;
		public boolean highSprenSpawned = false;
		public boolean ashSprenSpawned = false;
		public boolean cultivationSprenSpawned = false;
		public boolean crypticSprenSpawned = false;
		public boolean inkSprenSpawned = false;
		public boolean lightSprenSpawned = false;
		public boolean stonewardSprenSpawned = false;
		public boolean bondsmithSprenSpawned = false;
		public double truthwatcherSprenVar = 0;
		public double bondAmount = 0;
		public double radiant2Level = 0;
		public boolean receivedSprenblade = false;
		public double lastInfusionAmnt = 0;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.lashingAmount = original.lashingAmount;
		clone.stormlightConsumedAmnt = original.stormlightConsumedAmnt;
		clone.radiantLevel = original.radiantLevel;
		clone.sphereTypeInfused = original.sphereTypeInfused;
		clone.radiantTrueFalse = original.radiantTrueFalse;
		clone.sphereTypeDun = original.sphereTypeDun;
		clone.truthwatcherSprenSpawned = original.truthwatcherSprenSpawned;
		clone.honorSprenSpawned = original.honorSprenSpawned;
		clone.highSprenSpawned = original.highSprenSpawned;
		clone.ashSprenSpawned = original.ashSprenSpawned;
		clone.cultivationSprenSpawned = original.cultivationSprenSpawned;
		clone.crypticSprenSpawned = original.crypticSprenSpawned;
		clone.inkSprenSpawned = original.inkSprenSpawned;
		clone.lightSprenSpawned = original.lightSprenSpawned;
		clone.stonewardSprenSpawned = original.stonewardSprenSpawned;
		clone.bondsmithSprenSpawned = original.bondsmithSprenSpawned;
		clone.truthwatcherSprenVar = original.truthwatcherSprenVar;
		clone.bondAmount = original.bondAmount;
		clone.radiant2Level = original.radiant2Level;
		clone.receivedSprenblade = original.receivedSprenblade;
		clone.lastInfusionAmnt = original.lastInfusionAmnt;
		if (!event.isWasDeath()) {
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.lashingAmount = message.data.lashingAmount;
					variables.stormlightConsumedAmnt = message.data.stormlightConsumedAmnt;
					variables.radiantLevel = message.data.radiantLevel;
					variables.sphereTypeInfused = message.data.sphereTypeInfused;
					variables.radiantTrueFalse = message.data.radiantTrueFalse;
					variables.sphereTypeDun = message.data.sphereTypeDun;
					variables.truthwatcherSprenSpawned = message.data.truthwatcherSprenSpawned;
					variables.honorSprenSpawned = message.data.honorSprenSpawned;
					variables.highSprenSpawned = message.data.highSprenSpawned;
					variables.ashSprenSpawned = message.data.ashSprenSpawned;
					variables.cultivationSprenSpawned = message.data.cultivationSprenSpawned;
					variables.crypticSprenSpawned = message.data.crypticSprenSpawned;
					variables.inkSprenSpawned = message.data.inkSprenSpawned;
					variables.lightSprenSpawned = message.data.lightSprenSpawned;
					variables.stonewardSprenSpawned = message.data.stonewardSprenSpawned;
					variables.bondsmithSprenSpawned = message.data.bondsmithSprenSpawned;
					variables.truthwatcherSprenVar = message.data.truthwatcherSprenVar;
					variables.bondAmount = message.data.bondAmount;
					variables.radiant2Level = message.data.radiant2Level;
					variables.receivedSprenblade = message.data.receivedSprenblade;
					variables.lastInfusionAmnt = message.data.lastInfusionAmnt;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
