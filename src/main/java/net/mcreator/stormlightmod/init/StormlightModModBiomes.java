
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.stormlightmod.world.biome.ShatteredPlainsBiome;
import net.mcreator.stormlightmod.world.biome.ShadesmarBiome;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome SHATTERED_PLAINS = register("shattered_plains", ShatteredPlainsBiome.createBiome());
	public static Biome SHADESMAR = register("shadesmar", ShadesmarBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(StormlightModMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ShatteredPlainsBiome.init();
			ShadesmarBiome.init();
		});
	}
}
