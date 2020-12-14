
@OnlyIn(Dist.CLIENT)
public static class ModelVexModel extends BipedModel<VexEntity> {
	private final ModelRenderer leftWing;
	private final ModelRenderer rightWing;

	public ModelVexModel() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedLeftLeg.showModel = false;
		this.bipedHeadwear.showModel = false;
		this.bipedRightLeg = new ModelRenderer(this, 32, 0);
		this.bipedRightLeg.addBox(-1.0F, -1.0F, -2.0F, 6.0F, 10.0F, 4.0F, 0.0F);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.rightWing = new ModelRenderer(this, 0, 32);
		this.rightWing.addBox(-20.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
		this.leftWing = new ModelRenderer(this, 0, 32);
		this.leftWing.mirror = true;
		this.leftWing.addBox(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.rightWing, this.leftWing));
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}