
package net.mcreator.stormlightmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.stormlightmod.procedures.CurryFoodEatenProcedure;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class CurryItem extends StormlightModModElements.ModElement {
	@ObjectHolder("stormlight_mod:curry")
	public static final Item block = null;
	public CurryItem(StormlightModModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(10).saturation(2f).setAlwaysEdible().meat().build()));
			setRegistryName("curry");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 150;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("This food is hot and is called mens food in Roshar"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CurryFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
