package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.GravitationPotion;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class WillshaperPotionEffectProcedure extends StormlightModModElements.ModElement {
	public WillshaperPotionEffectProcedure(StormlightModModElements instance) {
		super(instance, 193);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WillshaperPotionEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:windrunner")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(GravitationPotion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).stormlightConsumedAmnt),
						(int) 1));
		}
	}
}
