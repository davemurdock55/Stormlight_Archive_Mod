package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.InfusedSapphireBroamItem;
import net.mcreator.stormlightmod.item.DunSapphireBroamItem;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class DunSapphireBromeRightClickedInAirProcedure extends StormlightModModElements.ModElement {
	public DunSapphireBromeRightClickedInAirProcedure(StormlightModModElements instance) {
		super(instance, 92);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DunSapphireBromeRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DunSapphireBromeRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getWorld().isRaining())) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(DunSapphireBroamItem.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(InfusedSapphireBroamItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
