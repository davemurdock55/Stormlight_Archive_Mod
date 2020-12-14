
package net.mcreator.stormlightmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.potion.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@StormlightModModElements.ModElement.Tag
public class RockbudBlock extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:rockbud")
	public static final Block block = null;
	public RockbudBlock(StormlightModModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		RandomPatchFeature feature = new RandomPatchFeature(BlockClusterFeatureConfig::deserialize) {
			@Override
			public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
				DimensionType dimensionType = world.getDimension().getType();
				boolean dimensionCriteria = false;
				if (dimensionType == DimensionType.OVERWORLD)
					dimensionCriteria = true;
				if (!dimensionCriteria)
					return false;
				return super.place(world, generator, random, pos, config);
			}
		};
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("stormlight_mod:shattered_plains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					feature.withConfiguration(
							(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()), new SimpleBlockPlacer()))
									.tries(64).build())
							.withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8, 0, 4))));
		}
	}
	public static class BlockCustomFlower extends FlowerBlock {
		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(1f, 1f).lightValue(0));
			setRegistryName("rockbud");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 1;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Rockbuds can be found on the shattered plains"));
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 1;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.WHEAT, (int) (2)));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.Plains;
		}
	}
}
