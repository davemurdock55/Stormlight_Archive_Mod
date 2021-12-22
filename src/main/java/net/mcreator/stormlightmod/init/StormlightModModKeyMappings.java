
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stormlightmod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fmlclient.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.stormlightmod.StormlightModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class StormlightModModKeyMappings {
	public static final KeyMapping RADIENT_POWER = new KeyMapping("key.stormlight_mod.radient_power", GLFW.GLFW_KEY_R, "key.categories.misc");
	public static final KeyMapping RADIENT_1_POWER_2 = new KeyMapping("key.stormlight_mod.radient_1_power_2", GLFW.GLFW_KEY_T, "key.categories.misc");
	public static final KeyMapping LASHING_AMOUNT_AMPLIFIER = new KeyMapping("key.stormlight_mod.lashing_amount_amplifier", GLFW.GLFW_KEY_3,
			"key.categories.misc");
	public static final KeyMapping LASHING_AMOUNT_1 = new KeyMapping("key.stormlight_mod.lashing_amount_1", GLFW.GLFW_KEY_1, "key.categories.misc");
	public static final KeyMapping LASHING_AMOUNT_2 = new KeyMapping("key.stormlight_mod.lashing_amount_2", GLFW.GLFW_KEY_2, "key.categories.misc");
	public static final KeyMapping HS = new KeyMapping("key.stormlight_mod.hs", GLFW.GLFW_KEY_Z, "key.categories.misc");
	public static final KeyMapping SKYBREAKERKEY = new KeyMapping("key.stormlight_mod.skybreakerkey", GLFW.GLFW_KEY_X, "key.categories.misc");
	public static final KeyMapping CULTIVATIONSPRENGUI = new KeyMapping("key.stormlight_mod.cultivationsprengui", GLFW.GLFW_KEY_C,
			"key.categories.misc");
	public static final KeyMapping TRUTHWATCHERKEY = new KeyMapping("key.stormlight_mod.truthwatcherkey", GLFW.GLFW_KEY_V, "key.categories.misc");
	public static final KeyMapping ELSECALLER_GUI = new KeyMapping("key.stormlight_mod.elsecaller_gui", GLFW.GLFW_KEY_V, "key.categories.misc");
	public static final KeyMapping ELSECALLERPOWER = new KeyMapping("key.stormlight_mod.elsecallerpower", GLFW.GLFW_KEY_T, "key.categories.misc");
	public static final KeyMapping EDGEDANCER_GROWTHINGS = new KeyMapping("key.stormlight_mod.edgedancer_growthings", GLFW.GLFW_KEY_R,
			"key.categories.misc");
	private static long RADIENT_POWER_LASTPRESS = 0;
	private static long RADIENT_1_POWER_2_LASTPRESS = 0;
	private static long LASHING_AMOUNT_AMPLIFIER_LASTPRESS = 0;
	private static long LASHING_AMOUNT_1_LASTPRESS = 0;
	private static long LASHING_AMOUNT_2_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(RADIENT_POWER);
		ClientRegistry.registerKeyBinding(RADIENT_1_POWER_2);
		ClientRegistry.registerKeyBinding(LASHING_AMOUNT_AMPLIFIER);
		ClientRegistry.registerKeyBinding(LASHING_AMOUNT_1);
		ClientRegistry.registerKeyBinding(LASHING_AMOUNT_2);
		ClientRegistry.registerKeyBinding(HS);
		ClientRegistry.registerKeyBinding(SKYBREAKERKEY);
		ClientRegistry.registerKeyBinding(CULTIVATIONSPRENGUI);
		ClientRegistry.registerKeyBinding(TRUTHWATCHERKEY);
		ClientRegistry.registerKeyBinding(ELSECALLER_GUI);
		ClientRegistry.registerKeyBinding(ELSECALLERPOWER);
		ClientRegistry.registerKeyBinding(EDGEDANCER_GROWTHINGS);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == RADIENT_POWER.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						RADIENT_POWER_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - RADIENT_POWER_LASTPRESS);
						StormlightModMod.PACKET_HANDLER.sendToServer(new RadientPowerMessage(1, dt));
						RadientPowerMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == RADIENT_1_POWER_2.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						RADIENT_1_POWER_2_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - RADIENT_1_POWER_2_LASTPRESS);
						StormlightModMod.PACKET_HANDLER.sendToServer(new Radient1Power2Message(1, dt));
						Radient1Power2Message.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == LASHING_AMOUNT_AMPLIFIER.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						LASHING_AMOUNT_AMPLIFIER_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - LASHING_AMOUNT_AMPLIFIER_LASTPRESS);
						StormlightModMod.PACKET_HANDLER.sendToServer(new LashingAmountAmplifierMessage(1, dt));
						LashingAmountAmplifierMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == LASHING_AMOUNT_1.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						LASHING_AMOUNT_1_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - LASHING_AMOUNT_1_LASTPRESS);
						StormlightModMod.PACKET_HANDLER.sendToServer(new LashingAmount1Message(1, dt));
						LashingAmount1Message.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == LASHING_AMOUNT_2.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						LASHING_AMOUNT_2_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - LASHING_AMOUNT_2_LASTPRESS);
						StormlightModMod.PACKET_HANDLER.sendToServer(new LashingAmount2Message(1, dt));
						LashingAmount2Message.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == HS.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new HSMessage(0, 0));
						HSMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == SKYBREAKERKEY.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new SkybreakerkeyMessage(0, 0));
						SkybreakerkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == CULTIVATIONSPRENGUI.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new CultivationsprenguiMessage(0, 0));
						CultivationsprenguiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == TRUTHWATCHERKEY.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new TruthwatcherkeyMessage(0, 0));
						TruthwatcherkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == ELSECALLER_GUI.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new ElsecallerGuiMessage(0, 0));
						ElsecallerGuiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == ELSECALLERPOWER.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new ElsecallerpowerMessage(0, 0));
						ElsecallerpowerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == EDGEDANCER_GROWTHINGS.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						StormlightModMod.PACKET_HANDLER.sendToServer(new EdgedancerGrowthingsMessage(0, 0));
						EdgedancerGrowthingsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
