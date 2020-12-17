package net.mcreator.stormlightmod.procedures;

import net.minecraft.util.math.RayTraceContext;
import net.minecraft.potion.Effects;
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
		if (((new Object() {
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
		}.check(entity)) || (new Object() {
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
		}.check(entity)))) {
			entity.setMotion(
					((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8, entity.getLook(1f).z * 8),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
							* ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new StormlightModModVariables.PlayerVariables())).radiantLevel)),
					((entity.getMotion().getY()) * ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).radiantLevel)),
					((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8, entity.getLook(1f).z * 8),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
							* ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new StormlightModModVariables.PlayerVariables())).radiantLevel)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 40, (int) 1));
		}
	}
}
