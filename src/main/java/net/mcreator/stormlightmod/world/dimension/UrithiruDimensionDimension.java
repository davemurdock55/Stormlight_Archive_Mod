
package net.mcreator.stormlightmod.world.dimension;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Set;
import java.util.HashSet;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

import com.google.common.collect.ImmutableSet;

@StormlightModModElements.ModElement.Tag
public class UrithiruDimensionDimension extends StormlightModModElements.ModElement {
	public UrithiruDimensionDimension(StormlightModModElements instance) {
		super(instance, 396);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Set<Block> replaceableBlocks = new HashSet<>();
		replaceableBlocks.add(Blocks.STONE);
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountains")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountains")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_hills")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_hills")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("snowy_mountains")).getGenerationSettings().getSurfaceBuilder()
				.get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("snowy_mountains")).getGenerationSettings().getSurfaceBuilder()
				.get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_mountains")).getGenerationSettings().getSurfaceBuilder()
				.get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("wooded_mountains")).getGenerationSettings().getSurfaceBuilder()
				.get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountain_edge")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("mountain_edge")).getGenerationSettings().getSurfaceBuilder().get()
				.getConfig().getUnder().getBlock());
		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
			@Override
			public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
				return new Vector3d(0.752941176471, 0.847058823529, 1);
			}

			@Override
			public boolean func_230493_a_(int x, int y) {
				return false;
			}
		};
		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper
						.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("stormlight_mod:urithiru_dimension"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
