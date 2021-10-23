package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class ShardplateBootsTickEventProcedure extends StormlightModModElements.ModElement {
	public ShardplateBootsTickEventProcedure(StormlightModModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure ShardplateBootsTickEvent!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				StormlightModMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShardplateBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.FEATHER_FALLING, (int) 10);
		((itemstack)).addEnchantment(Enchantments.PROTECTION, (int) 10);
		((itemstack)).addEnchantment(Enchantments.UNBREAKING, (int) 10);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 10, (int) 1, (true), (false)));
	}
}
