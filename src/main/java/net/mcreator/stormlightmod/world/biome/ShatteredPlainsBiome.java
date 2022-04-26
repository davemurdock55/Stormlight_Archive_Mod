
package net.mcreator.stormlightmod.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Direction;
import net.minecraft.state.BooleanProperty;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.stormlightmod.entity.ShardbearerEntity;
import net.mcreator.stormlightmod.block.ShatteredPlainRockBlock;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Set;
import java.util.Random;
import java.util.List;

import com.google.common.collect.ImmutableList;

@StormlightModModElements.ModElement.Tag
public class ShatteredPlainsBiome extends StormlightModModElements.ModElement {
	public static Biome biome;

	public ShatteredPlainsBiome(StormlightModModElements instance) {
		super(instance, 4);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(-16737895).setWaterFogColor(-16737895)
						.withSkyColor(7972607).withFoliageColor(-5195161).withGrassColor(-5195161).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(ShatteredPlainRockBlock.block.getDefaultState(),
								Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())));
				biomeGenerationSettings.withStructure(StructureFeatures.STRONGHOLD);
				biomeGenerationSettings.withStructure(StructureFeatures.MINESHAFT);
				biomeGenerationSettings.withStructure(StructureFeatures.PILLAGER_OUTPOST);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 4))));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
										ImmutableList.of(ShatteredPlainRockBlock.block.getDefaultState(), Blocks.STONE.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(1));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ShardbearerEntity.entity, 5, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 20, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.EVOKER, 20, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.RAVAGER, 20, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WANDERING_TRADER, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.VILLAGER, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.VINDICATOR, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.VEX, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.BAT, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CAVE_SPIDER, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.HORSE, 44, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.IRON_GOLEM, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HUSK, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PILLAGER, 20, 1, 4));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(1f).scale(0.16f).temperature(1f)
						.downfall(1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("stormlight_mod:shattered_plains"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)),
				BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.WET,
				BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MODIFIED);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 20));
	}

	private static class CustomLeaveVineTreeDecorator extends LeaveVineTreeDecorator {
		public static final CustomLeaveVineTreeDecorator instance = new CustomLeaveVineTreeDecorator();
		public static com.mojang.serialization.Codec<LeaveVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("shattered_plains_lvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.AIR.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator {
		public static final CustomTrunkVineTreeDecorator instance = new CustomTrunkVineTreeDecorator();
		public static com.mojang.serialization.Codec<CustomTrunkVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("shattered_plains_tvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.AIR.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomCocoaTreeDecorator extends CocoaTreeDecorator {
		public static final CustomCocoaTreeDecorator instance = new CustomCocoaTreeDecorator();
		public static com.mojang.serialization.Codec<CustomCocoaTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("shattered_plains_ctd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		public CustomCocoaTreeDecorator() {
			super(0.2f);
		}

		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		public void func_225576_a_(ISeedReader p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_,
				Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
			if (!(p_225576_2_.nextFloat() >= 0.2F)) {
				int i = p_225576_3_.get(0).getY();
				p_225576_3_.stream().filter((p_236867_1_) -> {
					return p_236867_1_.getY() - i <= 2;
				}).forEach((p_242865_5_) -> {
					for (Direction direction : Direction.Plane.HORIZONTAL) {
						if (p_225576_2_.nextFloat() <= 0.25F) {
							Direction direction1 = direction.getOpposite();
							BlockPos blockpos = p_242865_5_.add(direction1.getXOffset(), 0, direction1.getZOffset());
							if (Feature.isAirAt(p_225576_1_, blockpos)) {
								BlockState blockstate = Blocks.AIR.getDefaultState();
								this.func_227423_a_(p_225576_1_, blockpos, blockstate, p_225576_5_, p_225576_6_);
							}
						}
					}
				});
			}
		}
	}
}
