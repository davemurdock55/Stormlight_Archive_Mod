package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

public class MoonChekProcedure {

	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				StormlightModMod.LOGGER.warn("Failed to load dependency world for procedure MoonChek!");
			return 0;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return world.getDimensionType().getMoonPhase(world.func_241851_ab());
	}
}
