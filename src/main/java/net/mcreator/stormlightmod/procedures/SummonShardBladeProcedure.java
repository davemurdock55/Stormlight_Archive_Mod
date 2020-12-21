package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.ShardbladeItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class SummonShardBladeProcedure extends StormlightModModElements.ModElement {
	public SummonShardBladeProcedure(StormlightModModElements instance) {
		super(instance, 402);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SummonShardBlade!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:becominga_shardbearer")))
						.isDone()
				: false) && (entity.isSneaking()))) {
			if (((!((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ShardbladeItem.block, (int) (1)))
					: false))
					&& (((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).recievedShardBlade) == (false)))) {
				if ((((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StormlightModModVariables.PlayerVariables())).shardBladeClock) == 172)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(ShardbladeItem.block, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						boolean _setval = (boolean) (true);
						entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.recievedShardBlade = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((!((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ShardbladeItem.block, (int) (1)))
					: false))) {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.recievedShardBlade = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand())
			return;
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
