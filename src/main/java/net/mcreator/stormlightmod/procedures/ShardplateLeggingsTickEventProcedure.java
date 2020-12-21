package net.mcreator.stormlightmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class ShardplateLeggingsTickEventProcedure extends StormlightModModElements.ModElement {
	public ShardplateLeggingsTickEventProcedure(StormlightModModElements instance) {
		super(instance, 75);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShardplateLeggingsTickEvent!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ShardplateLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.PROTECTION, (int) 10);
		((itemstack)).addEnchantment(Enchantments.UNBREAKING, (int) 10);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60, (int) 0, (true), (false)));
	}
}
