
package net.mcreator.stormlightmod.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectInstance;

import net.mcreator.stormlightmod.StormlightModModElements;

@StormlightModModElements.ModElement.Tag
public class Bondsmith1PotionItemPotion extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:bondsmith_1")
	public static final Potion potionType = null;
	public Bondsmith1PotionItemPotion(StormlightModModElements instance) {
		super(instance, 177);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(Bondsmith1PotionEffect.potion, 3600, 0, false, true));
			setRegistryName("bondsmith_1");
		}
	}
}
