
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StormlightModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(StormlightModModMenus.HSSSSSSSS, HssssssssScreen::new);
			MenuScreens.register(StormlightModModMenus.SKYBREAKER, SkybreakerScreen::new);
			MenuScreens.register(StormlightModModMenus.CULTIVATION, CultivationScreen::new);
			MenuScreens.register(StormlightModModMenus.TRUTHWATCHERSPRENSPAWNING, TruthwatchersprenspawningScreen::new);
			MenuScreens.register(StormlightModModMenus.OATH_GATE, OathGateScreen::new);
			MenuScreens.register(StormlightModModMenus.ELSECALLER, ElsecallerScreen::new);
		});
	}
}
