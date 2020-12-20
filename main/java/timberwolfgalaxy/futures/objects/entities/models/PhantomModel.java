package timberwolfgalaxy.futures.objects.entities.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import timberwolfgalaxy.futures.objects.entities.abstracts.SegmentedModel;

public class PhantomModel<T extends Entity> extends SegmentedModel<T> {
  private final ModelRenderer body;
  
  private final ModelRenderer leftWingBody;
  
  private final ModelRenderer leftWing;
  
  private final ModelRenderer rightWingBody;
  
  private final ModelRenderer rightWing;
  
  private final ModelRenderer tail1;
  
  private final ModelRenderer tail2;
  
  public PhantomModel() {
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.body = new ModelRenderer(this, 0, 8);
    this.body.addBox(-3.0F, -2.0F, -8.0F, 5, 3, 9);
    this.tail1 = new ModelRenderer(this, 3, 20);
    this.tail1.addBox(-2.0F, 0.0F, 0.0F, 3, 2, 6);
    this.tail1.setRotationPoint(0.0F, -2.0F, 1.0F);
    this.body.addChild(this.tail1);
    this.tail2 = new ModelRenderer(this, 4, 29);
    this.tail2.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 6);
    this.tail2.setRotationPoint(0.0F, 0.5F, 6.0F);
    this.tail1.addChild(this.tail2);
    this.leftWingBody = new ModelRenderer(this, 23, 12);
    this.leftWingBody.addBox(0.0F, 0.0F, 0.0F, 6, 2, 9);
    this.leftWingBody.setRotationPoint(2.0F, -2.0F, -8.0F);
    this.leftWing = new ModelRenderer(this, 16, 24);
    this.leftWing.addBox(0.0F, 0.0F, 0.0F, 13, 1, 9);
    this.leftWing.setRotationPoint(6.0F, 0.0F, 0.0F);
    this.leftWingBody.addChild(this.leftWing);
    this.rightWingBody = new ModelRenderer(this, 23, 12);
    this.rightWingBody.mirror = true;
    this.rightWingBody.addBox(-6.0F, 0.0F, 0.0F, 6, 2, 9);
    this.rightWingBody.setRotationPoint(-3.0F, -2.0F, -8.0F);
    this.rightWing = new ModelRenderer(this, 16, 24);
    this.rightWing.mirror = true;
    this.rightWing.addBox(-13.0F, 0.0F, 0.0F, 13, 1, 9);
    this.rightWing.setRotationPoint(-6.0F, 0.0F, 0.0F);
    this.rightWingBody.addChild(this.rightWing);
    this.leftWingBody.rotateAngleZ = 0.1F;
    this.leftWing.rotateAngleZ = 0.1F;
    this.rightWingBody.rotateAngleZ = -0.1F;
    this.rightWing.rotateAngleZ = -0.1F;
    this.body.rotateAngleX = -0.1F;
    ModelRenderer lvt_1_1_ = new ModelRenderer(this, 0, 0);
    lvt_1_1_.addBox(-4.0F, -2.0F, -5.0F, 7, 3, 5);
    lvt_1_1_.setRotationPoint(0.0F, 1.0F, -7.0F);
    lvt_1_1_.rotateAngleX = 0.2F;
    this.body.addChild(lvt_1_1_);
    this.body.addChild(this.leftWingBody);
    this.body.addChild(this.rightWingBody);
  }
  
  public Iterable<ModelRenderer> getParts() {
    return (Iterable<ModelRenderer>)ImmutableList.of(this.body);
  }
  
  public void setRotationAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
    float lvt_7_1_ = ((p_225597_1_.getEntityId() * 3) + p_225597_4_) * 0.13F;
    float lvt_8_1_ = 16.0F;
    this.leftWingBody.rotateAngleZ = MathHelper.cos(lvt_7_1_) * 16.0F * 0.017453292F;
    this.leftWing.rotateAngleZ = MathHelper.cos(lvt_7_1_) * 16.0F * 0.017453292F;
    this.rightWingBody.rotateAngleZ = -this.leftWingBody.rotateAngleZ;
    this.rightWing.rotateAngleZ = -this.leftWing.rotateAngleZ;
    this.tail1.rotateAngleX = -(5.0F + MathHelper.cos(lvt_7_1_ * 2.0F) * 5.0F) * 0.017453292F;
    this.tail2.rotateAngleX = -(5.0F + MathHelper.cos(lvt_7_1_ * 2.0F) * 5.0F) * 0.017453292F;
  }
}
