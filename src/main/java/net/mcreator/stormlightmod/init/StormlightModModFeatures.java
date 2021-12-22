
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(RockbudFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, RockbudFeature.GENERATE_BIOMES,
				RockbudFeature.CONFIGURED_FEATURE));
		REGISTRY.put(SapphireOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				SapphireOreFeature.GENERATE_BIOMES, SapphireOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(AmethystoreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				AmethystoreFeature.GENERATE_BIOMES, AmethystoreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(SmokestoneoreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				SmokestoneoreFeature.GENERATE_BIOMES, SmokestoneoreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(HeliodororeFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				HeliodororeFeature.GENERATE_BIOMES, HeliodororeFeature.CONFIGURED_FEATURE));
		REGISTRY.put(RubyGemoreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, RubyGemoreFeature.GENERATE_BIOMES,
				RubyGemoreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(GarnetOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, GarnetOreFeature.GENERATE_BIOMES,
				GarnetOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(ZirconOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, ZirconOreFeature.GENERATE_BIOMES,
				ZirconOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(TopazOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TopazOreFeature.GENERATE_BIOMES,
				TopazOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(OathGatePlatformFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES,
				OathGatePlatformFeature.GENERATE_BIOMES, OathGatePlatformFeature.CONFIGURED_FEATURE));
		REGISTRY.put(UrithiruFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, UrithiruFeature.GENERATE_BIOMES,
				UrithiruFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
