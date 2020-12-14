package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Windrunner1Potion;
import net.mcreator.stormlightmod.potion.Skybreaker1Potion;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.Collection;

@StormlightModModElements.ModElement.Tag
public class LashingAmplifier2Procedure extends StormlightModModElements.ModElement {
	public LashingAmplifier2Procedure(StormlightModModElements instance) {
		super(instance, 161);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LashingAmplifier2!");
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
						if (effect.getPotion() == Windrunner1Potion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			{
				double _setval = (double) 2;
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
						if (effect.getPotion() == Skybreaker1Potion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			{
				double _setval = (double) 2;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lashingAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
