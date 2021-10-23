package net.mcreator.stormlightmod.procedures;

import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class SpearRightClickedInAirProcedure extends StormlightModModElements.ModElement {
	public SpearRightClickedInAirProcedure(StormlightModModElements instance) {
		super(instance, 235);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure SpearRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote) {
				ArrowEntity entityToSpawn = new ArrowEntity(_ent.world, (LivingEntity) entity);
				entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
				entityToSpawn.setDamage((float) 5);
				entityToSpawn.setKnockbackStrength((int) 5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
	}
}
