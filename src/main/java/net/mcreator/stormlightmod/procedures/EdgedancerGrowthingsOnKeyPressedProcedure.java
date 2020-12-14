package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class EdgedancerGrowthingsOnKeyPressedProcedure extends StormlightModModElements.ModElement {
	public EdgedancerGrowthingsOnKeyPressedProcedure(StormlightModModElements instance) {
		super(instance, 389);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EdgedancerGrowthingsOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure EdgedancerGrowthingsOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure EdgedancerGrowthingsOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure EdgedancerGrowthingsOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EdgedancerGrowthingsOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("stormlight_mod:edgedancerlevel_1")))
						.isDone()
				: false)) {
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z)) || BoneMealItem
					.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
			}
		}
	}
}
