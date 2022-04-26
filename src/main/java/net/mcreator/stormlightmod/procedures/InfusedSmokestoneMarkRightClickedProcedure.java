package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.InfusedSmokestoneMarkItem;
import net.mcreator.stormlightmod.item.DunSmokestoneMarkItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class InfusedSmokestoneMarkRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				StormlightModMod.LOGGER.warn("Failed to load dependency world for procedure InfusedSmokestoneMarkRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure InfusedSmokestoneMarkRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			ItemStack _setval = new ItemStack(InfusedSmokestoneMarkItem.block);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeInfused = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			ItemStack _setval = new ItemStack(DunSmokestoneMarkItem.block);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeDun = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		InfusedMarkRightClickedProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
