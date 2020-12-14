
package net.mcreator.stormlightmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.stormlightmod.StormlightModModElements;

@StormlightModModElements.ModElement.Tag
public class SmallDiamondgemItem extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:small_diamondgem")
	public static final Item block = null;
	public SmallDiamondgemItem(StormlightModModElements instance) {
		super(instance, 357);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("small_diamondgem");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
