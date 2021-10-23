package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.InfusedZirconBroamItem;
import net.mcreator.stormlightmod.item.DunZirconBroamItem;
import net.mcreator.stormlightmod.StormlightModModElements;
import net.mcreator.stormlightmod.StormlightModMod;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class DunZirconBromeItemInInventoryTickProcedure extends StormlightModModElements.ModElement {
	public DunZirconBromeItemInInventoryTickProcedure(StormlightModModElements instance) {
		super(instance, 97);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StormlightModMod.LOGGER.warn("Failed to load dependency entity for procedure DunZirconBromeItemInInventoryTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				StormlightModMod.LOGGER.warn("Failed to load dependency world for procedure DunZirconBromeItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getWorld().isRaining())) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(DunZirconBroamItem.block);
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(InfusedZirconBroamItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
