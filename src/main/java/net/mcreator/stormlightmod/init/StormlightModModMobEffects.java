
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StormlightModModMobEffects {
	private static final List<MobEffect> REGISTRY = new ArrayList<>();
	public static final MobEffect WINDRUNNER_1 = register(new Windrunner1MobEffect());
	public static final MobEffect SKYBREAKER_1 = register(new Skybreaker1MobEffect());
	public static final MobEffect GRAVITATION = register(new GravitationMobEffect());
	public static final MobEffect LIGHTWEAVER_1 = register(new Lightweaver1MobEffect());
	public static final MobEffect DUSTBRINGER_1 = register(new Dustbringer1MobEffect());
	public static final MobEffect TRUTHWATCHER_1 = register(new Truthwatcher1MobEffect());
	public static final MobEffect ELSECALLER_1 = register(new Elsecaller1MobEffect());
	public static final MobEffect WILLSHAPER_1 = register(new Willshaper1MobEffect());
	public static final MobEffect STONEWARD_1 = register(new Stoneward1MobEffect());
	public static final MobEffect BONDSMITH_1 = register(new Bondsmith1MobEffect());
	public static final MobEffect EDGEDANCER_1 = register(new Edgedancer1MobEffect());

	private static MobEffect register(MobEffect effect) {
		REGISTRY.add(effect);
		return effect;
	}

	@SubscribeEvent
	public static void registerMobEffects(RegistryEvent.Register<MobEffect> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MobEffect[0]));
	}
}
