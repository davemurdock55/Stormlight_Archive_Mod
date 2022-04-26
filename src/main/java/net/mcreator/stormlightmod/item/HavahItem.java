
package net.mcreator.stormlightmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.stormlightmod.StormlightModModElements;

@StormlightModModElements.ModElement.Tag
public class HavahItem extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:havah_helmet")
	public static final Item helmet = null;
	@ObjectHolder("stormlight_mod:havah_chestplate")
	public static final Item body = null;
	@ObjectHolder("stormlight_mod:havah_leggings")
	public static final Item legs = null;
	@ObjectHolder("stormlight_mod:havah_boots")
	public static final Item boots = null;

	public HavahItem(StormlightModModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 6;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 2, 2, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 50;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.step"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.BLUE_WOOL), new ItemStack(Blocks.WHITE_WOOL),
						new ItemStack(Blocks.LIGHT_GRAY_WOOL));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "havah";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "stormlight_mod:textures/models/armor/vorin_havah_blue__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("havah_chestplate"));
	}

}
