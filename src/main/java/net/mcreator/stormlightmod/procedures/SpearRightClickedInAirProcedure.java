package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class SpearRightClickedInAirProcedure extends StormlightModModElements.ModElement {
	public SpearRightClickedInAirProcedure(StormlightModModElements instance) {
		super(instance, 235);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SpearRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SpearRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
			ArrowEntity entityToSpawn = new ArrowEntity(world.getWorld(), (LivingEntity) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
			entityToSpawn.setDamage((float) 5);
			entityToSpawn.setKnockbackStrength((int) 5);
			world.addEntity(entityToSpawn);
		}
	}
}
