package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Windrunner1PotionEffect;
import net.mcreator.stormlightmod.potion.Skybreaker1PotionEffect;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;
import java.util.Collection;

@StormlightModModElements.ModElement.Tag
public class LashingAmplifier3Procedure extends StormlightModModElements.ModElement {
	public LashingAmplifier3Procedure(StormlightModModElements instance) {
		super(instance, 160);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure LashingAmplifier3!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean LashingAmplifier3 = false;
		double ThirdLashing = 0;
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Windrunner1PotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			{
				double _setval = (double) 3;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lashingAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Skybreaker1PotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			{
				double _setval = (double) 3;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lashingAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
