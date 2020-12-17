package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.potion.Edgedancer1Potion;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.Collection;

@StormlightModModElements.ModElement.Tag
public class PressREdgedancerProcedure extends StormlightModModElements.ModElement {
	public PressREdgedancerProcedure(StormlightModModElements instance) {
		super(instance, 399);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PressREdgedancer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PressREdgedancer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PressREdgedancer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PressREdgedancer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PressREdgedancer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Edgedancer1Potion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z)) || BoneMealItem
					.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 1), (int) y, (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 1), (int) y, (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x + 1), (int) y, (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 2), (int) y, (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 2), (int) y, (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x + 2), (int) y, (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 1), (int) y, (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 1), (int) y, (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x - 1), (int) y, (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 2), (int) y, (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 2), (int) y, (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x - 2), (int) y, (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y + 1), (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y + 1), (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) (y + 1), (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y + 2), (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y + 2), (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) (y + 2), (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y - 1), (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y - 1), (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) (y - 1), (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y - 2), (int) z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) (y - 2), (int) z),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) (y - 2), (int) z), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z + 1)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z + 1)),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) (z + 1)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z + 2)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z + 2)),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) (z + 2)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z - 1)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z - 1)),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) (z - 1)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z - 2)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) (z - 2)),
							(Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) (z - 2)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
							new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x + 2), (int) y, (int) (z + 2)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
							new BlockPos((int) (x + 2), (int) y, (int) (z + 2)), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x + 2), (int) y, (int) (z + 2)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
							new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 2), (int) y, (int) (z - 2)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
							new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), 0);
			}
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) (x - 2), (int) y, (int) (z - 2)))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
							new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), (Direction) null)) {
				if (!world.getWorld().isRemote)
					world.getWorld().playEvent(2005, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), 0);
			}
		}
	}
}
