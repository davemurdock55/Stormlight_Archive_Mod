package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class InfusedBroamRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				StormlightModMod.LOGGER.warn("Failed to load dependency world for procedure InfusedBroamRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure InfusedBroamRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:radiant")))
						.isDone()
				: false) {
			{
				double _setval = 6000;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stormlightConsumedAmnt = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING,
						(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION,
						(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:windrunner")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Windrunner1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:skybreakerlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Skybreaker1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:dustbringerlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Dustbringer1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:edgedancerlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Edgedancer1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:truthwatcherlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Truthwatcher1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:lightweaverlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Lightweaver1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:elsecallerlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Elsecaller1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:willshaperlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Willshaper1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:stonewardlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Stoneward1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			} else if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("stormlight_mod:bond_smithlevel_1")))
							.isDone()
					: false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Bondsmith1PotionEffect.potion,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING,
							(int) StormlightModModVariables.WorldVariables.get(world).bromeStormlightAmount, (int) 1));
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StormlightModModVariables.PlayerVariables())).sphereTypeInfused);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = ((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StormlightModModVariables.PlayerVariables())).sphereTypeDun);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
