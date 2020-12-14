// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
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

	public custom_model() {
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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
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
}