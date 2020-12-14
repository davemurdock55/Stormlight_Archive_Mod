// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer legleft;
	private final ModelRenderer legright;
	private final ModelRenderer legrightback1;
	private final ModelRenderer legleftback1;
	private final ModelRenderer legleftback2;
	private final ModelRenderer legrightback2;
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer tail;
	private final ModelRenderer head;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;

	public custom_model() {
		textureWidth = 16;
		textureHeight = 16;

		legleft = new ModelRenderer(this);
		legleft.setRotationPoint(5.0F, 20.0F, 4.0F);
		

		legright = new ModelRenderer(this);
		legright.setRotationPoint(5.0F, 20.0F, 4.0F);
		

		legrightback1 = new ModelRenderer(this);
		legrightback1.setRotationPoint(5.0F, 20.0F, -4.0F);
		

		legleftback1 = new ModelRenderer(this);
		legleftback1.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		legleftback2 = new ModelRenderer(this);
		legleftback2.setRotationPoint(-1.0F, 24.0F, 5.0F);
		

		legrightback2 = new ModelRenderer(this);
		legrightback2.setRotationPoint(-4.0F, 24.0F, 4.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -1.0F, 6.0F, -2.0F, 0.0F, 4.0F, false);
		body.setTextureOffset(0, 0).addBox(-8.0F, -6.0F, -3.0F, 14.0F, -2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(12.0F, -10.0F, -5.0F, -6.0F, -4.0F, 8.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-17.0F, -5.0F, -1.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-17.0F, -5.0F, -1.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.5672F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-17.0F, -5.0F, -1.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.3491F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-16.0F, -5.0F, -1.0F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.2182F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-17.0F, -5.0F, -3.0F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.0436F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-18.0F, -5.0F, -1.0F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.0436F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-16.0F, -5.0F, -1.0F);
		body.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.48F, 0.0F);
		cube_r7.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-17.0F, -5.0F, -1.0F);
		body.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.48F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-17.0F, -5.0F, -2.0F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.6981F, 0.0F);
		cube_r9.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-18.0F, -5.0F, -2.0F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, -0.0436F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-16.0F, -6.0F, -1.0F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 1.6581F);
		cube_r11.setTextureOffset(0, 0).addBox(1.0F, 6.0F, 0.0F, -1.0F, -6.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-14.0F, -8.0F, -1.0F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.9163F);
		cube_r12.setTextureOffset(0, 0).addBox(1.0F, 3.0F, 0.0F, -1.0F, -3.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-12.0F, -9.0F, -1.0F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, 0.9163F);
		cube_r13.setTextureOffset(0, 0).addBox(1.0F, 3.0F, 0.0F, -1.0F, -3.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-10.0F, -9.0F, -1.0F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, 0.9163F);
		cube_r14.setTextureOffset(0, 0).addBox(-1.0F, 3.0F, 0.0F, 1.0F, -3.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-9.0F, -10.0F, -1.0F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.0873F, 0.6981F);
		cube_r15.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 1.0F, -2.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-8.0F, -11.0F, -1.0F);
		body.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, 0.6981F);
		cube_r16.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 1.0F, -2.0F, 1.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-9.0F, 0.0F, -1.0F);
		body.addChild(tail);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(-17.0F, -3.0F, -1.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(29.0F, -5.0F, -3.0F, -6.0F, 2.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -7.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -7.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(26.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(26.0F, -7.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(24.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(24.0F, -7.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(24.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(24.0F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(26.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(26.0F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(28.0F, -7.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(30.0F, -10.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(29.0F, -10.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-6.0F, 0.0F, -4.0F);
		bb_main.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 1.9199F);
		cube_r17.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-6.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 1.8762F);
		cube_r18.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-1.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, 1.9199F);
		cube_r19.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-1.0F, 0.0F, -4.0F);
		bb_main.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 2.0071F);
		cube_r20.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(4.0F, 0.0F, -4.0F);
		bb_main.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 1.9635F);
		cube_r21.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(4.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, 2.0071F);
		cube_r22.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-4.0F, 0.0F, -4.0F);
		bb_main.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, 0.5672F);
		cube_r23.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r23.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-6.0F, 0.0F, -3.0F);
		bb_main.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, -0.0873F, 0.3491F);
		cube_r24.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-5.0F, -4.0F, -4.0F);
		bb_main.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0873F, 0.0F, 1.1345F);
		cube_r25.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-6.0F, 0.0F, 2.0F);
		bb_main.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, -0.0873F, 0.3491F);
		cube_r26.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-5.0F, -4.0F, 1.0F);
		bb_main.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0873F, 0.0F, 1.1345F);
		cube_r27.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-1.0F, 0.0F, 2.0F);
		bb_main.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, -0.0873F, 0.3491F);
		cube_r28.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(1.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 0.5672F);
		cube_r29.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(0.0F, -4.0F, 1.0F);
		bb_main.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0873F, 0.0F, 1.1345F);
		cube_r30.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-1.0F, 0.0F, -3.0F);
		bb_main.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, -0.0873F, 0.3491F);
		cube_r31.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(0.0F, -4.0F, -4.0F);
		bb_main.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0873F, 0.0F, 1.1345F);
		cube_r32.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(4.0F, 0.0F, -3.0F);
		bb_main.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, -0.0873F, 0.3491F);
		cube_r33.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(6.0F, 0.0F, -4.0F);
		bb_main.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, 0.5672F);
		cube_r34.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r34.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(5.0F, -4.0F, -4.0F);
		bb_main.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0873F, 0.0F, 1.1345F);
		cube_r35.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(5.0F, -4.0F, 1.0F);
		bb_main.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0873F, 0.0F, 1.1345F);
		cube_r36.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(4.0F, 0.0F, 2.0F);
		bb_main.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, -0.0873F, 0.3491F);
		cube_r37.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, -1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		legleft.render(matrixStack, buffer, packedLight, packedOverlay);
		legright.render(matrixStack, buffer, packedLight, packedOverlay);
		legrightback1.render(matrixStack, buffer, packedLight, packedOverlay);
		legleftback1.render(matrixStack, buffer, packedLight, packedOverlay);
		legleftback2.render(matrixStack, buffer, packedLight, packedOverlay);
		legrightback2.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}