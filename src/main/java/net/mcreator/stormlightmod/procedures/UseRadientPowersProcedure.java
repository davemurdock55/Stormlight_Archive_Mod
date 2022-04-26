package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Windrunner1PotionEffect;
import net.mcreator.stormlightmod.potion.Willshaper1PotionEffect;
import net.mcreator.stormlightmod.potion.Truthwatcher1PotionEffect;
import net.mcreator.stormlightmod.potion.Stoneward1PotionEffect;
import net.mcreator.stormlightmod.potion.Skybreaker1PotionEffect;
import net.mcreator.stormlightmod.potion.Lightweaver1PotionEffect;
import net.mcreator.stormlightmod.potion.Elsecaller1PotionEffect;
import net.mcreator.stormlightmod.potion.Edgedancer1PotionEffect;
import net.mcreator.stormlightmod.potion.Dustbringer1PotionEffect;
import net.mcreator.stormlightmod.potion.Bondsmith1PotionEffect;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

public class UseRadientPowersProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure UseRadientPowers!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING,
					(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
					(int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.REGENERATION, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:windrunner")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Windrunner1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:skybreakerlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Skybreaker1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:dustbringerlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Dustbringer1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:edgedancerlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Edgedancer1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:truthwatcherlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Truthwatcher1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:lightweaverlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Lightweaver1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:elsecallerlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Elsecaller1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:willshaperlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Willshaper1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:stonewardlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Stoneward1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:bond_smithlevel_1")))
						.isDone()
				: false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Bondsmith1PotionEffect.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		}
		{
			double _setval = 0;
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lastInfusionAmnt = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
