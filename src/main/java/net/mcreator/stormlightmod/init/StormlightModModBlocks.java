
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.stormlightmod.block.ZirconOreBlock;
import net.mcreator.stormlightmod.block.TopazOreBlock;
import net.mcreator.stormlightmod.block.SmokestoneoreBlock;
import net.mcreator.stormlightmod.block.ShatteredPlainRockBlock;
import net.mcreator.stormlightmod.block.ShadesmarObsidianBlock;
import net.mcreator.stormlightmod.block.ShadesbeadsBlock;
import net.mcreator.stormlightmod.block.SapphireOreBlock;
import net.mcreator.stormlightmod.block.RubyGemoreBlock;
import net.mcreator.stormlightmod.block.RockbudBlock;
import net.mcreator.stormlightmod.block.RockBudGroundBlock;
import net.mcreator.stormlightmod.block.RockBudBlockBlock;
import net.mcreator.stormlightmod.block.OathGateKeyBlockBlock;
import net.mcreator.stormlightmod.block.HeliodororeBlock;
import net.mcreator.stormlightmod.block.GarnetOreBlock;
import net.mcreator.stormlightmod.block.AmethystoreBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block SHATTERED_PLAIN_ROCK = register(new ShatteredPlainRockBlock());
	public static final Block ROCKBUD = register(new RockbudBlock());
	public static final Block ROCK_BUD_GROUND = register(new RockBudGroundBlock());
	public static final Block SHADESBEADS = register(new ShadesbeadsBlock());
	public static final Block SHADESMAR_OBSIDIAN = register(new ShadesmarObsidianBlock());
	public static final Block SHADESMAR_1_PORTAL = register(new Shadesmar1PortalBlock());
	public static final Block ROCK_BUD_BLOCK = register(new RockBudBlockBlock());
	public static final Block SAPPHIRE_ORE = register(new SapphireOreBlock());
	public static final Block AMETHYSTORE = register(new AmethystoreBlock());
	public static final Block SMOKESTONEORE = register(new SmokestoneoreBlock());
	public static final Block HELIODORORE = register(new HeliodororeBlock());
	public static final Block RUBY_GEMORE = register(new RubyGemoreBlock());
	public static final Block GARNET_ORE = register(new GarnetOreBlock());
	public static final Block ZIRCON_ORE = register(new ZirconOreBlock());
	public static final Block TOPAZ_ORE = register(new TopazOreBlock());
	public static final Block OATH_GATE_KEY_BLOCK = register(new OathGateKeyBlockBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			RockbudBlock.registerRenderLayer();
		}
	}
}
