package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class CurryFoodEatenProcedure extends StormlightModModElements.ModElement {
	public CurryFoodEatenProcedure(StormlightModModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CurryFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 60, (int) 1));
	}
}
