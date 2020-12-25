// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelvex extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer leg0;
	private final ModelRenderer legright;

	public Modelvex() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 8.0F, 8.0F, -2.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, 3.0F, -4.0F, 8.0F, 10.0F, 6.0F, -2.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		rightArm.setTextureOffset(40, 16).addBox(0.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, -3.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setRotationPoint(-6.0F, 11.0F, 0.0F);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		leftArm.setTextureOffset(40, 16).addBox(-4.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, -3.0F, true);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leg0.setTextureOffset(0, 16).addBox(1.0F, -4.0F, -3.0F, 4.0F, 12.0F, 4.0F, -3.0F, false);
		leg0.setTextureOffset(32, 0).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 12.0F, 4.0F, -3.0F, false);

		legright = new ModelRenderer(this);
		legright.setRotationPoint(5.9F, 10.0F, 0.0F);
		leg0.addChild(legright);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightItem.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg0.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.legright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}