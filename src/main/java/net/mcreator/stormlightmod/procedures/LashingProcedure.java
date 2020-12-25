package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Windrunner1Potion;
import net.mcreator.stormlightmod.potion.Skybreaker1Potion;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.Collection;

@StormlightModModElements.ModElement.Tag
public class LashingProcedure extends StormlightModModElements.ModElement {
	public LashingProcedure(StormlightModModElements instance) {
		super(instance, 119);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Lashing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
			entity.setMotion(((entity.getMotion().getX()) * 2), ((entity.getMotion().getY()) * 2), ((entity.getMotion().getZ()) * 2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 40, (int) 1));
		} else if ((new Object() {
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
			entity.setMotion(((entity.getMotion().getX()) * 2), ((entity.getMotion().getY()) * 2), ((entity.getMotion().getZ()) * 2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 40, (int) 1));
		}
	}
}
