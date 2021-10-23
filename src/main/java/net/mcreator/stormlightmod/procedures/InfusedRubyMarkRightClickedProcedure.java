package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.InfusedRubyMarkItem;
import net.mcreator.stormlightmod.item.DunRubyMarkItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class InfusedRubyMarkRightClickedProcedure extends StormlightModModElements.ModElement {
	public InfusedRubyMarkRightClickedProcedure(StormlightModModElements instance) {
		super(instance, 268);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure InfusedRubyMarkRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				StormlightModMod.LOGGER.warn("Failed to load dependency world for procedure InfusedRubyMarkRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			ItemStack _setval = new ItemStack(InfusedRubyMarkItem.block);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeInfused = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			ItemStack _setval = new ItemStack(DunRubyMarkItem.block);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeDun = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			InfusedMarkRightClickedProcedure.executeProcedure($_dependencies);
		}
	}
}
