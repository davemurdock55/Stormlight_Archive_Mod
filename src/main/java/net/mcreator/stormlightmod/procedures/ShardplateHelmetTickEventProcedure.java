package net.mcreator.stormlightmod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class ShardplateHelmetTickEventProcedure extends StormlightModModElements.ModElement {
	public ShardplateHelmetTickEventProcedure(StormlightModModElements instance) {
		super(instance, 77);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				StormlightModMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShardplateHelmetTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.PROTECTION, (int) 10);
		((itemstack)).addEnchantment(Enchantments.UNBREAKING, (int) 10);
	}
}
