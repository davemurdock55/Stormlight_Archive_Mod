package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.SprenbladeItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

public class CultivationSprenRightClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure CultivationSprenRightClick!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure CultivationSprenRightClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof ServerPlayerEntity) && (sourceentity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) sourceentity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("minecraft:adventure/hero_of_the_village")))
						.isDone()
				: false) {
			{
				boolean _setval = (true);
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.radiantTrueFalse = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new StormlightModModVariables.PlayerVariables())).receivedSprenblade == false) {
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SprenbladeItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.receivedSprenblade = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
