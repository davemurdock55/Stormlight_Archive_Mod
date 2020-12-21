package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class ShardBladeSummonClockProcedure extends StormlightModModElements.ModElement {
	public ShardBladeSummonClockProcedure(StormlightModModElements instance) {
		super(instance, 403);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShardBladeSummonClock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:becominga_shardbearer")))
						.isDone()
				: false)) {
			if ((((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new StormlightModModVariables.PlayerVariables())).shardBladeClock) <= 172)) {
				{
					double _setval = (double) (((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).shardBladeClock) + 1);
					entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shardBladeClock = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = (double) 0;
					entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shardBladeClock = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
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
}
