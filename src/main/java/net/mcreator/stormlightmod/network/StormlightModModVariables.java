package net.mcreator.stormlightmod.network;

import net.minecraftforge.fmllegacy.network.PacketDistributor;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		StormlightModMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		StormlightModMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
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

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "stormlight_mod_worldvars";
		public double bromeStormlightAmount = 6000.0;
		public double markStormlightAmount = 3000.0;
		public double chipStormlightAmount = 1500.0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			bromeStormlightAmount = nbt.getDouble("bromeStormlightAmount");
			markStormlightAmount = nbt.getDouble("markStormlightAmount");
			chipStormlightAmount = nbt.getDouble("chipStormlightAmount");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("bromeStormlightAmount", bromeStormlightAmount);
			nbt.putDouble("markStormlightAmount", markStormlightAmount);
			nbt.putDouble("chipStormlightAmount", chipStormlightAmount);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "stormlight_mod_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("stormlight_mod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
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
			if (entity instanceof ServerPlayer serverPlayer)
				StormlightModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("lashingAmount", lashingAmount);
			nbt.putDouble("stormlightConsumedAmnt", stormlightConsumedAmnt);
			nbt.putDouble("radiantLevel", radiantLevel);
			nbt.put("sphereTypeInfused", sphereTypeInfused.save(new CompoundTag()));
			nbt.putBoolean("radiantTrueFalse", radiantTrueFalse);
			nbt.put("sphereTypeDun", sphereTypeDun.save(new CompoundTag()));
			nbt.putBoolean("truthwatcherSprenSpawned", truthwatcherSprenSpawned);
			nbt.putBoolean("honorSprenSpawned", honorSprenSpawned);
			nbt.putBoolean("highSprenSpawned", highSprenSpawned);
			nbt.putBoolean("ashSprenSpawned", ashSprenSpawned);
			nbt.putBoolean("cultivationSprenSpawned", cultivationSprenSpawned);
			nbt.putBoolean("crypticSprenSpawned", crypticSprenSpawned);
			nbt.putBoolean("inkSprenSpawned", inkSprenSpawned);
			nbt.putBoolean("lightSprenSpawned", lightSprenSpawned);
			nbt.putBoolean("stonewardSprenSpawned", stonewardSprenSpawned);
			nbt.putBoolean("bondsmithSprenSpawned", bondsmithSprenSpawned);
			nbt.putDouble("truthwatcherSprenVar", truthwatcherSprenVar);
			nbt.putDouble("bondAmount", bondAmount);
			nbt.putDouble("radiant2Level", radiant2Level);
			nbt.putBoolean("receivedSprenblade", receivedSprenblade);
			nbt.putDouble("lastInfusionAmnt", lastInfusionAmnt);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			lashingAmount = nbt.getDouble("lashingAmount");
			stormlightConsumedAmnt = nbt.getDouble("stormlightConsumedAmnt");
			radiantLevel = nbt.getDouble("radiantLevel");
			sphereTypeInfused = ItemStack.of(nbt.getCompound("sphereTypeInfused"));
			radiantTrueFalse = nbt.getBoolean("radiantTrueFalse");
			sphereTypeDun = ItemStack.of(nbt.getCompound("sphereTypeDun"));
			truthwatcherSprenSpawned = nbt.getBoolean("truthwatcherSprenSpawned");
			honorSprenSpawned = nbt.getBoolean("honorSprenSpawned");
			highSprenSpawned = nbt.getBoolean("highSprenSpawned");
			ashSprenSpawned = nbt.getBoolean("ashSprenSpawned");
			cultivationSprenSpawned = nbt.getBoolean("cultivationSprenSpawned");
			crypticSprenSpawned = nbt.getBoolean("crypticSprenSpawned");
			inkSprenSpawned = nbt.getBoolean("inkSprenSpawned");
			lightSprenSpawned = nbt.getBoolean("lightSprenSpawned");
			stonewardSprenSpawned = nbt.getBoolean("stonewardSprenSpawned");
			bondsmithSprenSpawned = nbt.getBoolean("bondsmithSprenSpawned");
			truthwatcherSprenVar = nbt.getDouble("truthwatcherSprenVar");
			bondAmount = nbt.getDouble("bondAmount");
			radiant2Level = nbt.getDouble("radiant2Level");
			receivedSprenblade = nbt.getBoolean("receivedSprenblade");
			lastInfusionAmnt = nbt.getDouble("lastInfusionAmnt");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
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
