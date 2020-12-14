package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class GravitationPotionStartedappliedProcedure extends StormlightModModElements.ModElement {
	public GravitationPotionStartedappliedProcedure(StormlightModModElements instance) {
		super(instance, 155);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GravitationPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			LashingProcedure.executeProcedure($_dependencies);
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.SLOW_FALLING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt), (int) 1));
	}
}
