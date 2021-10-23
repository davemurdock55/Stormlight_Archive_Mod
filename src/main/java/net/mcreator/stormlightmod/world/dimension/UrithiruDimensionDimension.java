
package net.mcreator.stormlightmod.world.dimension;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.stormlightmod.StormlightModModElements;

import javax.annotation.Nullable;

import java.util.function.LongFunction;
import java.util.function.BiFunction;
import java.util.HashSet;
import java.util.Arrays;

import com.google.common.collect.ImmutableSet;

@StormlightModModElements.ModElement.Tag
public class UrithiruDimensionDimension extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:urithiru_dimension")
	public static final ModDimension dimension = null;
	public static DimensionType type = null;
	private static Biome[] dimensionBiomes;
	public UrithiruDimensionDimension(StormlightModModElements instance) {
		super(instance, 396);
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("urithiru_dimension"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("stormlight_mod:urithiru_dimension")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("stormlight_mod:urithiru_dimension"), dimension, null, true);
		}
		type = DimensionType.byName(new ResourceLocation("stormlight_mod:urithiru_dimension"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountains")),
				ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_mountains")),
				ForgeRegistries.BIOMES.getValue(new ResourceLocation("snowy_mountains")),
				ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountain_edge")),
				ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_hills")),};
	}
	public static class CustomModDimension extends ModDimension {
		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return CustomDimension::new;
		}
	}

	public static class CustomDimension extends Dimension {
		private BiomeProviderCustom biomeProviderCustom = null;
		public CustomDimension(World world, DimensionType type) {
			super(world, type, 0.5f);
			this.nether = false;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public Vec3d getFogColor(float celestialAngle, float partialTicks) {
			return new Vec3d(0.752941176471, 0.847058823529, 1);
		}

		@Override
		public ChunkGenerator<?> createChunkGenerator() {
			if (this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override
		public boolean isSurfaceWorld() {
			return true;
		}

		@Override
		public boolean canRespawnHere() {
			return true;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public boolean doesXZShowFog(int x, int z) {
			return false;
		}

		@Override
		public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
			return SleepResult.ALLOW;
		}

		@Nullable
		public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
			return null;
		}

		@Nullable
		public BlockPos findSpawn(int x, int z, boolean checkValid) {
			return null;
		}

		@Override
		public boolean doesWaterVaporize() {
			return false;
		}

		@Override /**
					 * Calculates the angle of sun and moon in the sky relative to a specified time
					 * (usually worldTime)
					 */
		public float calculateCelestialAngle(long worldTime, float partialTicks) {
			double d0 = MathHelper.frac((double) worldTime / 24000.0D - 0.25D);
			double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
			return (float) (d0 * 2.0D + d1) / 3.0F;
		}
	}

	public static class ChunkProviderModded extends OverworldChunkGenerator {
		public ChunkProviderModded(IWorld world, BiomeProvider provider) {
			super(world, provider, new OverworldGenSettings() {
				public BlockState getDefaultBlock() {
					return Blocks.STONE.getDefaultState();
				}

				public BlockState getDefaultFluid() {
					return Blocks.WATER.getDefaultState();
				}
			});
			this.randomSeed.skip(5349);
		}

		@Override
		public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
		}
	}

	public static class BiomeLayerCustom implements IC0Transformer {
		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}
	}

	public static class BiomeProviderCustom extends BiomeProvider {
		private Layer genBiomes;
		private static boolean biomesPatched = false;
		public BiomeProviderCustom(World world) {
			super(new HashSet<Biome>(Arrays.asList(dimensionBiomes)));
			this.genBiomes = getBiomeLayer(world.getSeed());
			if (!biomesPatched) {
				for (Biome biome : this.biomes) {
					biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new CaveWorldCarver(ProbabilityConfig::deserialize, 256) {
						{
							carvableBlocks = ImmutableSet.of(Blocks.STONE, biome.getSurfaceBuilder().getConfig().getTop().getBlock(),
									biome.getSurfaceBuilder().getConfig().getUnder().getBlock());
						}
					}, new ProbabilityConfig(0.14285715f)));
				}
				biomesPatched = true;
			}
		}

		public Biome getNoiseBiome(int x, int y, int z) {
			return this.genBiomes.func_215738_a(x, z);
		}

		private Layer getBiomeLayer(long seed) {
			LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);
			IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
			IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);
			return new Layer(biomeLayer);
		}
	}
}
