package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class MoonChekProcedure extends StormlightModModElements.ModElement {
	public MoonChekProcedure(StormlightModModElements instance) {
		super(instance, 132);
	}

	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure MoonChek!");
			return 0;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (world.getCurrentMoonPhaseFactor());
	}
}
