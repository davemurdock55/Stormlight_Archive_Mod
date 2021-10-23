
package net.mcreator.stormlightmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.stormlightmod.StormlightModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@StormlightModModElements.ModElement.Tag
public class AxehoundEntity extends StormlightModModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("axehound").setRegistryName("axehound");
	public AxehoundEntity(StormlightModModElements instance) {
		super(instance, 393);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -26368, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("axehound_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 10, 4, 7));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("stormlight_mod:textures/axehoundtrytwo.png");
				}
			};
		});
	}
	public static class CustomEntity extends TameableEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new OwnerHurtTargetGoal(this));
			this.goalSelector.addGoal(2, new FollowParentGoal(this, 0.8));
			this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
			this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(6, new BreedGoal(this, 1));
			this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(9, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.processInteract(sourceentity, hand);
			} else if (this.world.isRemote) {
				retval = this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack);
			} else {
				if (this.isTamed()) {
					if (this.isOwner(sourceentity)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal((float) item.getFood().getHealing());
							retval = true;
						} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal(4);
							retval = true;
						} else {
							retval = super.processInteract(sourceentity, hand);
						}
					}
				} else if (this.isBreedingItem(itemstack)) {
					this.consumeItemFromStack(sourceentity, itemstack);
					if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.setTamedBy(sourceentity);
						this.world.setEntityState(this, (byte) 7);
					} else {
						this.world.setEntityState(this, (byte) 6);
					}
					this.enablePersistence();
					retval = true;
				} else {
					retval = super.processInteract(sourceentity, hand);
					if (retval)
						this.enablePersistence();
				}
			}
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(this.world);
			retval.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(retval)), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (Items.BEEF == stack.getItem())
				return true;
			if (Items.MUTTON == stack.getItem())
				return true;
			if (Items.CHICKEN == stack.getItem())
				return true;
			if (Items.RABBIT == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer tail;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer leftleg1;
		private final ModelRenderer rightleg1;
		private final ModelRenderer leftleg2;
		private final ModelRenderer rightleg2;
		private final ModelRenderer leftleg3;
		private final ModelRenderer rightleg3;
		private final ModelRenderer head;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		public Modelcustom_model() {
			textureWidth = 256;
			textureHeight = 256;
			body = new ModelRenderer(this);
			body.setRotationPoint(30.0F, 22.0F, 2.0F);
			body.setTextureOffset(84, 0).addBox(-17.0F, -16.0F, -3.0F, 14.0F, 11.0F, 15.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-1.0F, -2.0F, -1.0F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.3054F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 38).addBox(-17.0F, -15.0F, -26.0F, 16.0F, 14.0F, 21.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.2182F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-20.0F, -17.0F, -16.0F, 20.0F, 16.0F, 22.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(29.0F, 30.0F, -16.0F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			tail.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.1309F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 73).addBox(-15.0F, -14.0F, -24.0F, 12.0F, 11.0F, 17.0F, 0.0F, false);
			cube_r3.setTextureOffset(57, 57).addBox(-15.0F, -14.0F, -24.0F, 12.0F, 11.0F, 17.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 1.0F, -8.0F);
			tail.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.2182F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(41, 85).addBox(-14.0F, -14.0F, -24.0F, 10.0F, 9.0F, 17.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -1.0F, -15.0F);
			tail.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.2618F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(78, 94).addBox(-12.0F, -12.0F, -24.0F, 6.0F, 7.0F, 17.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -9.0F, -28.0F);
			tail.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.3491F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(53, 38).addBox(-22.0F, -4.0F, -24.0F, 28.0F, 1.0F, 17.0F, 0.0F, false);
			leftleg1 = new ModelRenderer(this);
			leftleg1.setRotationPoint(25.0F, 16.0F, 6.075F);
			leftleg1.setTextureOffset(66, 111).addBox(-19.0F, -4.0F, -5.075F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			leftleg1.setTextureOffset(107, 97).addBox(-17.0F, -6.0F, -8.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			rightleg1 = new ModelRenderer(this);
			rightleg1.setRotationPoint(7.0F, 13.0F, 1.0F);
			rightleg1.setTextureOffset(54, 111).addBox(27.0F, -1.0F, 0.0F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			rightleg1.setTextureOffset(0, 101).addBox(19.0F, -3.0F, -2.925F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			leftleg2 = new ModelRenderer(this);
			leftleg2.setRotationPoint(25.0F, 18.0F, -4.525F);
			leftleg2.setTextureOffset(62, 111).addBox(-19.0F, -6.0F, -5.475F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			leftleg2.setTextureOffset(107, 85).addBox(-17.0F, -6.0F, -8.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			rightleg2 = new ModelRenderer(this);
			rightleg2.setRotationPoint(16.6F, 9.0F, 18.075F);
			rightleg2.setTextureOffset(98, 56).addBox(10.4F, 3.0F, -30.6F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			rightleg2.setTextureOffset(50, 111).addBox(17.4F, 3.0F, -28.075F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			leftleg3 = new ModelRenderer(this);
			leftleg3.setRotationPoint(16.6F, 9.0F, 18.075F);
			leftleg3.setTextureOffset(58, 111).addBox(-10.6F, 5.0F, -36.075F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			leftleg3.setTextureOffset(20, 107).addBox(-8.6F, 5.3F, -40.2F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			rightleg3 = new ModelRenderer(this);
			rightleg3.setRotationPoint(16.6F, 9.0F, 18.075F);
			rightleg3.setTextureOffset(84, 26).addBox(9.4F, 5.3F, -40.2F, 7.0F, 6.0F, 6.0F, 0.0F, false);
			rightleg3.setTextureOffset(46, 111).addBox(17.4F, 5.0F, -36.075F, 1.0F, 22.0F, 1.0F, 2.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(43.0F, 20.3F, -14.125F);
			head.setTextureOffset(10, 0).addBox(-27.4F, -12.3F, 30.2F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-20.4F, -12.3F, 30.2F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(62, 0).addBox(-27.0F, -13.3F, 28.125F, 8.0F, 6.0F, 7.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-17.0F, -15.3F, 28.125F);
			head.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.3491F, 0.0F, 0.0873F);
			cube_r7.setTextureOffset(12, 5).addBox(-3.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-27.0F, -12.3F, 29.125F);
			head.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.2618F, -0.1745F, 0.0F);
			cube_r8.setTextureOffset(0, 15).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-26.0F, -15.3F, 28.125F);
			head.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.3491F, 0.0F, 0.0873F);
			cube_r9.setTextureOffset(12, 5).addBox(-3.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-18.0F, -12.3F, 29.125F);
			head.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.2618F, -0.1745F, 0.0F);
			cube_r10.setTextureOffset(0, 15).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-30.0F, -5.1F, 30.125F);
			head.addChild(cube_r11);
			setRotationAngle(cube_r11, -0.1309F, -0.1309F, 0.0F);
			cube_r11.setTextureOffset(0, 10).addBox(3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-16.3F, -8.3F, 28.125F);
			head.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.9599F, 0.1309F, 0.0F);
			cube_r12.setTextureOffset(6, 6).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-29.7F, -8.3F, 28.125F);
			head.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.9599F, -0.1309F, 0.0F);
			cube_r13.setTextureOffset(6, 11).addBox(3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-25.0F, -5.3F, 28.125F);
			head.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.3491F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(78, 85).addBox(-1.0F, -2.0F, 0.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-16.0F, -5.1F, 30.125F);
			head.addChild(cube_r15);
			setRotationAngle(cube_r15, -0.1309F, 0.1309F, 0.0F);
			cube_r15.setTextureOffset(0, 5).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg2.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg2.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg3.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg3.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightleg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightleg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tail.rotateAngleX = f2 / 20.f;
			this.cube_r4.rotateAngleX = f2 / 20.f;
			this.cube_r5.rotateAngleX = f2 / 20.f;
			this.cube_r6.rotateAngleX = f2 / 20.f;
			this.cube_r3.rotateAngleX = f2 / 20.f;
			this.leftleg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftleg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftleg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
