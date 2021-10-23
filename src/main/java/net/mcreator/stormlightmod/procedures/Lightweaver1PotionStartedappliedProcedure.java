package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class Lightweaver1PotionStartedappliedProcedure extends StormlightModModElements.ModElement {
	public Lightweaver1PotionStartedappliedProcedure(StormlightModModElements instance) {
		super(instance, 406);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure Lightweaver1PotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity)
					.addPotionEffect(
							new EffectInstance(Effects.INVISIBILITY,
									(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt),
									(int) 1, (false), (false)));
	}
}
