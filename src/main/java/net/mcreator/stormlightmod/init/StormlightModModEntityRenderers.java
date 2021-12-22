
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StormlightModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(StormlightModModEntities.SHARDBEARER, ShardbearerRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.NIGHTWATCHER, NightwatcherRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.HONOR_SPREN, HonorSprenRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.PARSHENDIARCHER, ParshendiarcherRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.PARSHENDIARCHER_PROJECTILE, ThrownItemRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.ELSECALLERFUSED, ElsecallerfusedRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.WINDRUNNERFUSED, WindrunnerfusedRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.WINDRUNNERFUSED_PROJECTILE, ThrownItemRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.HIGH_SPREN, HighSprenRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.TRUTHWATCHER_SPREN, TruthwatcherSprenRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.CULTIVATION_SPREN, CultivationSprenRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.INK_SPREN, InkSprenRenderer::new);
		event.registerEntityRenderer(StormlightModModEntities.AXEHOUND, AxehoundRenderer::new);
	}
}
