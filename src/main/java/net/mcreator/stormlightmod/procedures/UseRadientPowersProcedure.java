package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Windrunner1Potion;
import net.mcreator.stormlightmod.potion.Willshaper1Potion;
import net.mcreator.stormlightmod.potion.Truthwatcher1Potion;
import net.mcreator.stormlightmod.potion.Stoneward1Potion;
import net.mcreator.stormlightmod.potion.Skybreaker1Potion;
import net.mcreator.stormlightmod.potion.Lightweaver1Potion;
import net.mcreator.stormlightmod.potion.Elsecaller1Potion;
import net.mcreator.stormlightmod.potion.Edgedancer1Potion;
import net.mcreator.stormlightmod.potion.Dustbringer1Potion;
import net.mcreator.stormlightmod.potion.Bondsmith1Potion;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class UseRadientPowersProcedure extends StormlightModModElements.ModElement {
	public UseRadientPowersProcedure(StormlightModModElements instance) {
		super(instance, 386);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure UseRadientPowers!");
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
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:windrunner")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Windrunner1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:skybreakerlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Skybreaker1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:dustbringerlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Dustbringer1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:edgedancerlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Edgedancer1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:truthwatcherlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Truthwatcher1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:lightweaverlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Lightweaver1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:elsecallerlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Elsecaller1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:willshaperlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Willshaper1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:stonewardlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Stoneward1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:bond_smithlevel_1")))
						.isDone()
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Bondsmith1Potion.potion,
						(int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt),
						(int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(Effects.GLOWING, (int) ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new StormlightModModVariables.PlayerVariables())).lastInfusionAmnt), (int) 1));
		}
		{
			double _setval = (double) 0;
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lastInfusionAmnt = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
