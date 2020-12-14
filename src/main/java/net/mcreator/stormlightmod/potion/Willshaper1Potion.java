
package net.mcreator.stormlightmod.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import net.mcreator.stormlightmod.StormlightModModElements;

@StormlightModModElements.ModElement.Tag
public class Willshaper1Potion extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:willshaper_1")
	public static final Effect potion = null;
	@ObjectHolder("stormlight_mod:willshaper_1")
	public static final Potion potionType = null;
	public Willshaper1Potion(StormlightModModElements instance) {
		super(instance, 175);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(potion, 3600));
			setRegistryName("willshaper_1");
		}
	}

	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.BENEFICIAL, -6710887);
			setRegistryName("willshaper_1");
			potionIcon = new ResourceLocation("stormlight_mod:textures/image_1.png");
		}

		@Override
		public String getName() {
			return "effect.willshaper_1";
		}

		@Override
		public boolean isBeneficial() {
			return true;
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
