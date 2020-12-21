package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.ShardbladeItem;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class ShardbladeDespawnProcedureProcedure extends StormlightModModElements.ModElement {
	public ShardbladeDespawnProcedureProcedure(StormlightModModElements instance) {
		super(instance, 400);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShardbladeDespawnProcedure!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ShardbladeDespawnProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(ShardbladeItem.block, (int) (1)).getItem())) {
			if (!entity.world.isRemote)
				entity.remove();
		}
	}

	@SubscribeEvent
	public void onGemDropped(ItemTossEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
		ItemStack itemstack = event.getEntityItem().getItem();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemstack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
