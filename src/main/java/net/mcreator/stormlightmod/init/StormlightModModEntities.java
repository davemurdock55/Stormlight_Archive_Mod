
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.stormlightmod.entity.WindrunnerfusedEntity;
import net.mcreator.stormlightmod.entity.TruthwatcherSprenEntity;
import net.mcreator.stormlightmod.entity.ShardbearerEntity;
import net.mcreator.stormlightmod.entity.ParshendiarcherEntity;
import net.mcreator.stormlightmod.entity.NightwatcherEntity;
import net.mcreator.stormlightmod.entity.InkSprenEntity;
import net.mcreator.stormlightmod.entity.HonorSprenEntity;
import net.mcreator.stormlightmod.entity.HighSprenEntity;
import net.mcreator.stormlightmod.entity.ElsecallerfusedEntity;
import net.mcreator.stormlightmod.entity.CultivationSprenEntity;
import net.mcreator.stormlightmod.entity.AxehoundEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<ShardbearerEntity> SHARDBEARER = register("shardbearer",
			EntityType.Builder.<ShardbearerEntity>of(ShardbearerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShardbearerEntity::new).fireImmune().sized(0.83f, 2.5f));
	public static final EntityType<NightwatcherEntity> NIGHTWATCHER = register("nightwatcher",
			EntityType.Builder.<NightwatcherEntity>of(NightwatcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NightwatcherEntity::new).fireImmune().sized(1f, 1f));
	public static final EntityType<HonorSprenEntity> HONOR_SPREN = register("honor_spren",
			EntityType.Builder.<HonorSprenEntity>of(HonorSprenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HonorSprenEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<ParshendiarcherEntity> PARSHENDIARCHER = register("parshendiarcher",
			EntityType.Builder.<ParshendiarcherEntity>of(ParshendiarcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ParshendiarcherEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<ParshendiarcherEntityProjectile> PARSHENDIARCHER_PROJECTILE = register("entitybulletparshendiarcher",
			EntityType.Builder.<ParshendiarcherEntityProjectile>of(ParshendiarcherEntityProjectile::new, MobCategory.MISC)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1)
					.setCustomClientFactory(ParshendiarcherEntityProjectile::new).sized(0.5f, 0.5f));
	public static final EntityType<ElsecallerfusedEntity> ELSECALLERFUSED = register("elsecallerfused",
			EntityType.Builder.<ElsecallerfusedEntity>of(ElsecallerfusedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ElsecallerfusedEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<WindrunnerfusedEntity> WINDRUNNERFUSED = register("windrunnerfused",
			EntityType.Builder.<WindrunnerfusedEntity>of(WindrunnerfusedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WindrunnerfusedEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<WindrunnerfusedEntityProjectile> WINDRUNNERFUSED_PROJECTILE = register("entitybulletwindrunnerfused",
			EntityType.Builder.<WindrunnerfusedEntityProjectile>of(WindrunnerfusedEntityProjectile::new, MobCategory.MISC)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1)
					.setCustomClientFactory(WindrunnerfusedEntityProjectile::new).sized(0.5f, 0.5f));
	public static final EntityType<HighSprenEntity> HIGH_SPREN = register("high_spren",
			EntityType.Builder.<HighSprenEntity>of(HighSprenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HighSprenEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<TruthwatcherSprenEntity> TRUTHWATCHER_SPREN = register("truthwatcher_spren",
			EntityType.Builder.<TruthwatcherSprenEntity>of(TruthwatcherSprenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TruthwatcherSprenEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<CultivationSprenEntity> CULTIVATION_SPREN = register("cultivation_spren",
			EntityType.Builder.<CultivationSprenEntity>of(CultivationSprenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CultivationSprenEntity::new).fireImmune().sized(0.4f, 0.3f));
	public static final EntityType<InkSprenEntity> INK_SPREN = register("ink_spren",
			EntityType.Builder.<InkSprenEntity>of(InkSprenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InkSprenEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<AxehoundEntity> AXEHOUND = register("axehound",
			EntityType.Builder.<AxehoundEntity>of(AxehoundEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(AxehoundEntity::new).sized(0.6f, 1.8f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ShardbearerEntity.init();
			NightwatcherEntity.init();
			HonorSprenEntity.init();
			ParshendiarcherEntity.init();
			ElsecallerfusedEntity.init();
			WindrunnerfusedEntity.init();
			HighSprenEntity.init();
			TruthwatcherSprenEntity.init();
			CultivationSprenEntity.init();
			InkSprenEntity.init();
			AxehoundEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SHARDBEARER, ShardbearerEntity.createAttributes().build());
		event.put(NIGHTWATCHER, NightwatcherEntity.createAttributes().build());
		event.put(HONOR_SPREN, HonorSprenEntity.createAttributes().build());
		event.put(PARSHENDIARCHER, ParshendiarcherEntity.createAttributes().build());
		event.put(ELSECALLERFUSED, ElsecallerfusedEntity.createAttributes().build());
		event.put(WINDRUNNERFUSED, WindrunnerfusedEntity.createAttributes().build());
		event.put(HIGH_SPREN, HighSprenEntity.createAttributes().build());
		event.put(TRUTHWATCHER_SPREN, TruthwatcherSprenEntity.createAttributes().build());
		event.put(CULTIVATION_SPREN, CultivationSprenEntity.createAttributes().build());
		event.put(INK_SPREN, InkSprenEntity.createAttributes().build());
		event.put(AXEHOUND, AxehoundEntity.createAttributes().build());
	}
}
