package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.stormlightmod.particle.GlorySprenParticle;
import net.mcreator.stormlightmod.entity.HonorSprenEntity;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.Iterator;

@StormlightModModElements.ModElement.Tag
public class GetHonorSpreggProcedure extends StormlightModModElements.ModElement {
	public GetHonorSpreggProcedure(StormlightModModElements instance) {
		super(instance, 226);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GetHonorSpregg!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GetHonorSpregg!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GetHonorSpregg!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GetHonorSpregg!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GetHonorSpregg!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			Entity entityToSpawn = new HonorSprenEntity.CustomEntity(HonorSprenEntity.entity, world.getWorld());
			entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (!world.getWorld().isRemote) {
			world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			world.getWorld().playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 5, 3, 3, 3, 1);
		}
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("stormlight_mod:windrunner"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("stormlight_mod:radiant"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.radiantTrueFalse = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new StormlightModModVariables.PlayerVariables())).bondAmount) + 1);
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.bondAmount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StormlightModModVariables.PlayerVariables())).radiantLevel) > 0)) {
			{
				double _setval = (double) 1;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.radiant2Level = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = (double) 1;
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.radiantLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(GlorySprenParticle.particle, x, y, z, (int) 10, 3, 3, 3, 1);
		}
	}
}
