
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModPotions {
	private static final List<Potion> REGISTRY = new ArrayList<>();
	public static final Potion WINDRUNNER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.WINDRUNNER_1, 3600, 0, false, true)).setRegistryName("windrunner_1"));
	public static final Potion SKYBREAKER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.SKYBREAKER_1, 3600, 0, false, true)).setRegistryName("skybreaker_1"));
	public static final Potion GRAVITATION = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.GRAVITATION, 3600, 0, false, true)).setRegistryName("gravitation"));
	public static final Potion LIGHTWEAVER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.LIGHTWEAVER_1, 3600, 0, false, true)).setRegistryName("lightweaver_1"));
	public static final Potion DUSTBRINGER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.DUSTBRINGER_1, 3600, 0, false, true)).setRegistryName("dustbringer_1"));
	public static final Potion TRUTHWATCHER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.TRUTHWATCHER_1, 3600, 0, false, true)).setRegistryName("truthwatcher_1"));
	public static final Potion ELSECALLER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.ELSECALLER_1, 3600, 0, false, true)).setRegistryName("elsecaller_1"));
	public static final Potion WILLSHAPER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.WILLSHAPER_1, 3600, 0, false, true)).setRegistryName("willshaper_1"));
	public static final Potion STONEWARD_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.STONEWARD_1, 3600, 0, false, true)).setRegistryName("stoneward_1"));
	public static final Potion BONDSMITH_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.BONDSMITH_1, 3600, 0, false, true)).setRegistryName("bondsmith_1"));
	public static final Potion EDGEDANCER_1 = register(
			new Potion(new MobEffectInstance(StormlightModModMobEffects.EDGEDANCER_1, 3600, 0, false, true)).setRegistryName("edgedancer_1"));

	private static Potion register(Potion potion) {
		REGISTRY.add(potion);
		return potion;
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Potion[0]));
	}
}
