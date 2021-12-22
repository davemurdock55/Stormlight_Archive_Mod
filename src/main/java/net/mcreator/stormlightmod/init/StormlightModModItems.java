
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.stormlightmod.item.ZirconGemItem;
import net.mcreator.stormlightmod.item.UncookedcurryItem;
import net.mcreator.stormlightmod.item.TopazGemItem;
import net.mcreator.stormlightmod.item.SprenbladeItem;
import net.mcreator.stormlightmod.item.SpearItem;
import net.mcreator.stormlightmod.item.SmokestoneGemItem;
import net.mcreator.stormlightmod.item.SmallZirconGemItem;
import net.mcreator.stormlightmod.item.SmallTopazGemItem;
import net.mcreator.stormlightmod.item.SmallSmokestonerecipeItem;
import net.mcreator.stormlightmod.item.SmallSapphireItem;
import net.mcreator.stormlightmod.item.SmallRubyGemItem;
import net.mcreator.stormlightmod.item.SmallHeliodorGemItem;
import net.mcreator.stormlightmod.item.SmallGarnetGemItem;
import net.mcreator.stormlightmod.item.SmallEmeraldGemItem;
import net.mcreator.stormlightmod.item.SmallDiamondgemItem;
import net.mcreator.stormlightmod.item.SmallAmethystgemItem;
import net.mcreator.stormlightmod.item.ShardplateItem;
import net.mcreator.stormlightmod.item.ShardbladeItem;
import net.mcreator.stormlightmod.item.Shadesmar1Item;
import net.mcreator.stormlightmod.item.SapphireGemItem;
import net.mcreator.stormlightmod.item.RubyGemItem;
import net.mcreator.stormlightmod.item.MediumZirconGemItem;
import net.mcreator.stormlightmod.item.MediumTopazgemItem;
import net.mcreator.stormlightmod.item.MediumSmokestoneGemItem;
import net.mcreator.stormlightmod.item.MediumSapphireItem;
import net.mcreator.stormlightmod.item.MediumRubyGemItem;
import net.mcreator.stormlightmod.item.MediumHeliodorGemItem;
import net.mcreator.stormlightmod.item.MediumGarnetGemItem;
import net.mcreator.stormlightmod.item.MediumEmeraldGemItem;
import net.mcreator.stormlightmod.item.MediumDiamondGemItem;
import net.mcreator.stormlightmod.item.MediumAmethystgemItem;
import net.mcreator.stormlightmod.item.InfusedZirconchipItem;
import net.mcreator.stormlightmod.item.InfusedZirconMarkItem;
import net.mcreator.stormlightmod.item.InfusedZirconBroamItem;
import net.mcreator.stormlightmod.item.InfusedTopazMarkItem;
import net.mcreator.stormlightmod.item.InfusedTopazChipItem;
import net.mcreator.stormlightmod.item.InfusedTopazBroamItem;
import net.mcreator.stormlightmod.item.InfusedSmokestoneMarkItem;
import net.mcreator.stormlightmod.item.InfusedSmokestoneChipItem;
import net.mcreator.stormlightmod.item.InfusedSmokestoneBroamItem;
import net.mcreator.stormlightmod.item.InfusedSapphireMarkItem;
import net.mcreator.stormlightmod.item.InfusedSapphireChipItem;
import net.mcreator.stormlightmod.item.InfusedSapphireBroamItem;
import net.mcreator.stormlightmod.item.InfusedRubyMarkItem;
import net.mcreator.stormlightmod.item.InfusedRubyChipItem;
import net.mcreator.stormlightmod.item.InfusedRubyBroamItem;
import net.mcreator.stormlightmod.item.InfusedHeliodorMarkItem;
import net.mcreator.stormlightmod.item.InfusedHeliodorChipItem;
import net.mcreator.stormlightmod.item.InfusedHeliodorBroamItem;
import net.mcreator.stormlightmod.item.InfusedGarnetMarkItem;
import net.mcreator.stormlightmod.item.InfusedGarnetChipItem;
import net.mcreator.stormlightmod.item.InfusedGarnetBroamItem;
import net.mcreator.stormlightmod.item.InfusedEmeraldMarkItem;
import net.mcreator.stormlightmod.item.InfusedEmeraldChipItem;
import net.mcreator.stormlightmod.item.InfusedEmeraldBroamItem;
import net.mcreator.stormlightmod.item.InfusedDiamondMarkItem;
import net.mcreator.stormlightmod.item.InfusedDiamondChipItem;
import net.mcreator.stormlightmod.item.InfusedDiamondBroamItem;
import net.mcreator.stormlightmod.item.InfusedAmethystMarkItem;
import net.mcreator.stormlightmod.item.InfusedAmethystChipItem;
import net.mcreator.stormlightmod.item.InfusedAmethystBroamItem;
import net.mcreator.stormlightmod.item.HonorspreggItem;
import net.mcreator.stormlightmod.item.HeliodorGemItem;
import net.mcreator.stormlightmod.item.HavahItem;
import net.mcreator.stormlightmod.item.GarnetGemItem;
import net.mcreator.stormlightmod.item.DunZirconMarkItem;
import net.mcreator.stormlightmod.item.DunZirconChipItem;
import net.mcreator.stormlightmod.item.DunZirconBroamItem;
import net.mcreator.stormlightmod.item.DunTopazMarkItem;
import net.mcreator.stormlightmod.item.DunTopazChipItem;
import net.mcreator.stormlightmod.item.DunTopazBroamItem;
import net.mcreator.stormlightmod.item.DunSmokestoneMarkItem;
import net.mcreator.stormlightmod.item.DunSmokestoneChipItem;
import net.mcreator.stormlightmod.item.DunSmokestoneBroamItem;
import net.mcreator.stormlightmod.item.DunSapphireMarkItem;
import net.mcreator.stormlightmod.item.DunSapphireChipItem;
import net.mcreator.stormlightmod.item.DunSapphireBroamItem;
import net.mcreator.stormlightmod.item.DunRubyMarkItem;
import net.mcreator.stormlightmod.item.DunRubyChipItem;
import net.mcreator.stormlightmod.item.DunRubyBroamItem;
import net.mcreator.stormlightmod.item.DunHeliodorMarkItem;
import net.mcreator.stormlightmod.item.DunHeliodorChipItem;
import net.mcreator.stormlightmod.item.DunHeliodorBroamItem;
import net.mcreator.stormlightmod.item.DunGartnetchipItem;
import net.mcreator.stormlightmod.item.DunGarnetMarkItem;
import net.mcreator.stormlightmod.item.DunGarnetBroamItem;
import net.mcreator.stormlightmod.item.DunEmeraldMarkItem;
import net.mcreator.stormlightmod.item.DunEmeraldChipItem;
import net.mcreator.stormlightmod.item.DunEmeraldBroamItem;
import net.mcreator.stormlightmod.item.DunDiamondMarkItem;
import net.mcreator.stormlightmod.item.DunDiamondChipItem;
import net.mcreator.stormlightmod.item.DunDiamondBroamItem;
import net.mcreator.stormlightmod.item.DunAmethystMarkItem;
import net.mcreator.stormlightmod.item.DunAmethystChipItem;
import net.mcreator.stormlightmod.item.DunAmethystBroamItem;
import net.mcreator.stormlightmod.item.CurryItem;
import net.mcreator.stormlightmod.item.AmethystgemItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item INFUSED_DIAMOND_CHIP = register(new InfusedDiamondChipItem());
	public static final Item CURRY = register(new CurryItem());
	public static final Item SHARDBLADE = register(new ShardbladeItem());
	public static final Item SHARDPLATE_HELMET = register(new ShardplateItem.Helmet());
	public static final Item SHARDPLATE_CHESTPLATE = register(new ShardplateItem.Chestplate());
	public static final Item SHARDPLATE_LEGGINGS = register(new ShardplateItem.Leggings());
	public static final Item SHARDPLATE_BOOTS = register(new ShardplateItem.Boots());
	public static final Item SHARDBEARER = register(
			new SpawnEggItem(StormlightModModEntities.SHARDBEARER, -13421824, -6750208, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("shardbearer_spawn_egg"));
	public static final Item NIGHTWATCHER = register(
			new SpawnEggItem(StormlightModModEntities.NIGHTWATCHER, -16777216, -10066330, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("nightwatcher_spawn_egg"));
	public static final Item SPRENBLADE = register(new SprenbladeItem());
	public static final Item SHATTERED_PLAIN_ROCK = register(StormlightModModBlocks.SHATTERED_PLAIN_ROCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item ROCKBUD = register(StormlightModModBlocks.ROCKBUD, CreativeModeTab.TAB_DECORATIONS);
	public static final Item ROCK_BUD_GROUND = register(StormlightModModBlocks.ROCK_BUD_GROUND, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HONOR_SPREN = register(
			new SpawnEggItem(StormlightModModEntities.HONOR_SPREN, -16711681, -16737844, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("honor_spren_spawn_egg"));
	public static final Item SHADESBEADS_BUCKET = register(new ShadesbeadsItem());
	public static final Item SHADESMAR_OBSIDIAN = register(StormlightModModBlocks.SHADESMAR_OBSIDIAN, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item SHADESMAR_1 = register(new Shadesmar1Item());
	public static final Item DUN_EMERALD_CHIP = register(new DunEmeraldChipItem());
	public static final Item INFUSED_EMERALD_CHIP = register(new InfusedEmeraldChipItem());
	public static final Item DUN_GARTNETCHIP = register(new DunGartnetchipItem());
	public static final Item INFUSED_GARNET_CHIP = register(new InfusedGarnetChipItem());
	public static final Item PARSHENDIARCHER = register(
			new SpawnEggItem(StormlightModModEntities.PARSHENDIARCHER, -6710887, -3407821, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("parshendiarcher_spawn_egg"));
	public static final Item DUN_TOPAZ_CHIP = register(new DunTopazChipItem());
	public static final Item INFUSED_TOPAZ_CHIP = register(new InfusedTopazChipItem());
	public static final Item DUN_SAPPHIRE_CHIP = register(new DunSapphireChipItem());
	public static final Item DUN_SMOKESTONE_CHIP = register(new DunSmokestoneChipItem());
	public static final Item DUN_RUBY_CHIP = register(new DunRubyChipItem());
	public static final Item DUN_ZIRCON_CHIP = register(new DunZirconChipItem());
	public static final Item DUN_AMETHYST_CHIP = register(new DunAmethystChipItem());
	public static final Item DUN_HELIODOR_CHIP = register(new DunHeliodorChipItem());
	public static final Item DUN_EMERALD_MARK = register(new DunEmeraldMarkItem());
	public static final Item DUN_DIAMOND_MARK = register(new DunDiamondMarkItem());
	public static final Item DUN_SAPPHIRE_MARK = register(new DunSapphireMarkItem());
	public static final Item DUN_SMOKESTONE_MARK = register(new DunSmokestoneMarkItem());
	public static final Item DUN_RUBY_MARK = register(new DunRubyMarkItem());
	public static final Item DUN_DIAMOND_CHIP = register(new DunDiamondChipItem());
	public static final Item DUN_GARNET_MARK = register(new DunGarnetMarkItem());
	public static final Item DUN_AMETHYST_MARK = register(new DunAmethystMarkItem());
	public static final Item DUN_HELIODOR_MARK = register(new DunHeliodorMarkItem());
	public static final Item DUN_TOPAZ_MARK = register(new DunTopazMarkItem());
	public static final Item DUN_ZIRCON_MARK = register(new DunZirconMarkItem());
	public static final Item INFUSED_AMETHYST_CHIP = register(new InfusedAmethystChipItem());
	public static final Item INFUSED_ZIRCONCHIP = register(new InfusedZirconchipItem());
	public static final Item ROCK_BUD_BLOCK = register(StormlightModModBlocks.ROCK_BUD_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item UNCOOKEDCURRY = register(new UncookedcurryItem());
	public static final Item ELSECALLERFUSED = register(
			new SpawnEggItem(StormlightModModEntities.ELSECALLERFUSED, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("elsecallerfused_spawn_egg"));
	public static final Item WINDRUNNERFUSED = register(
			new SpawnEggItem(StormlightModModEntities.WINDRUNNERFUSED, -1, -3407872, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("windrunnerfused_spawn_egg"));
	public static final Item SPEAR = register(new SpearItem());
	public static final Item INFUSED_EMERALD_MARK = register(new InfusedEmeraldMarkItem());
	public static final Item INFUSED_DIAMOND_MARK = register(new InfusedDiamondMarkItem());
	public static final Item INFUSED_TOPAZ_MARK = register(new InfusedTopazMarkItem());
	public static final Item INFUSED_AMETHYST_MARK = register(new InfusedAmethystMarkItem());
	public static final Item INFUSED_GARNET_MARK = register(new InfusedGarnetMarkItem());
	public static final Item INFUSED_SAPPHIRE_CHIP = register(new InfusedSapphireChipItem());
	public static final Item INFUSED_SAPPHIRE_MARK = register(new InfusedSapphireMarkItem());
	public static final Item INFUSED_ZIRCON_MARK = register(new InfusedZirconMarkItem());
	public static final Item SAPPHIRE_GEM = register(new SapphireGemItem());
	public static final Item SAPPHIRE_ORE = register(StormlightModModBlocks.SAPPHIRE_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HAVAH_CHESTPLATE = register(new HavahItem.Chestplate());
	public static final Item MEDIUM_SAPPHIRE = register(new MediumSapphireItem());
	public static final Item SMALL_SAPPHIRE = register(new SmallSapphireItem());
	public static final Item AMETHYSTGEM = register(new AmethystgemItem());
	public static final Item MEDIUM_AMETHYSTGEM = register(new MediumAmethystgemItem());
	public static final Item SMALL_AMETHYSTGEM = register(new SmallAmethystgemItem());
	public static final Item AMETHYSTORE = register(StormlightModModBlocks.AMETHYSTORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DUN_EMERALD_BROAM = register(new DunEmeraldBroamItem());
	public static final Item DUN_DIAMOND_BROAM = register(new DunDiamondBroamItem());
	public static final Item DUN_SAPPHIRE_BROAM = register(new DunSapphireBroamItem());
	public static final Item DUN_SMOKESTONE_BROAM = register(new DunSmokestoneBroamItem());
	public static final Item DUN_RUBY_BROAM = register(new DunRubyBroamItem());
	public static final Item DUN_GARNET_BROAM = register(new DunGarnetBroamItem());
	public static final Item DUN_AMETHYST_BROAM = register(new DunAmethystBroamItem());
	public static final Item DUN_HELIODOR_BROAM = register(new DunHeliodorBroamItem());
	public static final Item DUN_TOPAZ_BROAM = register(new DunTopazBroamItem());
	public static final Item DUN_ZIRCON_BROAM = register(new DunZirconBroamItem());
	public static final Item INFUSED_EMERALD_BROAM = register(new InfusedEmeraldBroamItem());
	public static final Item INFUSED_DIAMOND_BROAM = register(new InfusedDiamondBroamItem());
	public static final Item INFUSED_TOPAZ_BROAM = register(new InfusedTopazBroamItem());
	public static final Item INFUSED_AMETHYST_BROAM = register(new InfusedAmethystBroamItem());
	public static final Item INFUSED_GARNET_BROAM = register(new InfusedGarnetBroamItem());
	public static final Item INFUSED_SAPPHIRE_BROAM = register(new InfusedSapphireBroamItem());
	public static final Item INFUSED_ZIRCON_BROAM = register(new InfusedZirconBroamItem());
	public static final Item HIGH_SPREN = register(
			new SpawnEggItem(StormlightModModEntities.HIGH_SPREN, -16777216, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("high_spren_spawn_egg"));
	public static final Item INFUSED_SMOKESTONE_CHIP = register(new InfusedSmokestoneChipItem());
	public static final Item INFUSED_SMOKESTONE_MARK = register(new InfusedSmokestoneMarkItem());
	public static final Item INFUSED_SMOKESTONE_BROAM = register(new InfusedSmokestoneBroamItem());
	public static final Item TRUTHWATCHER_SPREN = register(
			new SpawnEggItem(StormlightModModEntities.TRUTHWATCHER_SPREN, -65536, -3407872, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("truthwatcher_spren_spawn_egg"));
	public static final Item CULTIVATION_SPREN = register(
			new SpawnEggItem(StormlightModModEntities.CULTIVATION_SPREN, -13369549, -13382656, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("cultivation_spren_spawn_egg"));
	public static final Item INFUSED_RUBY_BROAM = register(new InfusedRubyBroamItem());
	public static final Item INFUSED_HELIODOR_BROAM = register(new InfusedHeliodorBroamItem());
	public static final Item INFUSED_HELIODOR_CHIP = register(new InfusedHeliodorChipItem());
	public static final Item INFUSED_HELIODOR_MARK = register(new InfusedHeliodorMarkItem());
	public static final Item SMOKESTONE_GEM = register(new SmokestoneGemItem());
	public static final Item MEDIUM_SMOKESTONE_GEM = register(new MediumSmokestoneGemItem());
	public static final Item SMALL_SMOKESTONERECIPE = register(new SmallSmokestonerecipeItem());
	public static final Item SMOKESTONEORE = register(StormlightModModBlocks.SMOKESTONEORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item INFUSED_RUBY_CHIP = register(new InfusedRubyChipItem());
	public static final Item INFUSED_RUBY_MARK = register(new InfusedRubyMarkItem());
	public static final Item HONORSPREGG = register(new HonorspreggItem());
	public static final Item HELIODOR_GEM = register(new HeliodorGemItem());
	public static final Item HELIODORORE = register(StormlightModModBlocks.HELIODORORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MEDIUM_HELIODOR_GEM = register(new MediumHeliodorGemItem());
	public static final Item SMALL_HELIODOR_GEM = register(new SmallHeliodorGemItem());
	public static final Item RUBY_GEM = register(new RubyGemItem());
	public static final Item RUBY_GEMORE = register(StormlightModModBlocks.RUBY_GEMORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MEDIUM_RUBY_GEM = register(new MediumRubyGemItem());
	public static final Item SMALL_RUBY_GEM = register(new SmallRubyGemItem());
	public static final Item GARNET_GEM = register(new GarnetGemItem());
	public static final Item GARNET_ORE = register(StormlightModModBlocks.GARNET_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MEDIUM_GARNET_GEM = register(new MediumGarnetGemItem());
	public static final Item SMALL_GARNET_GEM = register(new SmallGarnetGemItem());
	public static final Item ZIRCON_GEM = register(new ZirconGemItem());
	public static final Item ZIRCON_ORE = register(StormlightModModBlocks.ZIRCON_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MEDIUM_ZIRCON_GEM = register(new MediumZirconGemItem());
	public static final Item SMALL_ZIRCON_GEM = register(new SmallZirconGemItem());
	public static final Item MEDIUM_DIAMOND_GEM = register(new MediumDiamondGemItem());
	public static final Item SMALL_DIAMONDGEM = register(new SmallDiamondgemItem());
	public static final Item TOPAZ_GEM = register(new TopazGemItem());
	public static final Item TOPAZ_ORE = register(StormlightModModBlocks.TOPAZ_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MEDIUM_TOPAZGEM = register(new MediumTopazgemItem());
	public static final Item SMALL_TOPAZ_GEM = register(new SmallTopazGemItem());
	public static final Item MEDIUM_EMERALD_GEM = register(new MediumEmeraldGemItem());
	public static final Item SMALL_EMERALD_GEM = register(new SmallEmeraldGemItem());
	public static final Item OATH_GATE_KEY_BLOCK = register(StormlightModModBlocks.OATH_GATE_KEY_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item INK_SPREN = register(
			new SpawnEggItem(StormlightModModEntities.INK_SPREN, -16777216, -13948117, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("ink_spren_spawn_egg"));
	public static final Item AXEHOUND = register(
			new SpawnEggItem(StormlightModModEntities.AXEHOUND, -26368, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("axehound_spawn_egg"));

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
