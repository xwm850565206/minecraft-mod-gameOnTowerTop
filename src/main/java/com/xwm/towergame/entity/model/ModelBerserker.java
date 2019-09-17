package com.xwm.towergame.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCyberDemon - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelBerserker extends ModelBase {
    public ModelRenderer dhead;
    public ModelRenderer dbody;
    public ModelRenderer field_178720_f;
    public ModelRenderer drightarm;
    public ModelRenderer drightleg;
    public ModelRenderer dleftarm;
    public ModelRenderer dleftleg;
    public ModelRenderer tcik1;
    public ModelRenderer tcik2;
    public ModelRenderer tcik2_1;
    public ModelRenderer field_78116_cChild;
    public ModelRenderer field_78116_cChild_1;
    public ModelRenderer field_78116_cChild_2;
    public ModelRenderer field_78116_cChild_3;
    public ModelRenderer field_78116_cChild_4;
    public ModelRenderer field_78116_cChild_5;
    public ModelRenderer field_78116_cChild_6;
    public ModelRenderer field_78116_cChild_7;
    public ModelRenderer field_78115_eChild;
    public ModelRenderer field_78115_eChild_1;
    public ModelRenderer field_178723_hChild;
    public ModelRenderer field_178723_hChild_1;
    public ModelRenderer field_178721_jChild;
    public ModelRenderer field_178721_jChild_1;
    public ModelRenderer field_178721_jChild_2;
    public ModelRenderer field_178724_iChild;
    public ModelRenderer field_178724_iChild_1;
    public ModelRenderer field_178722_kChild;
    public ModelRenderer field_178722_kChild_1;
    public ModelRenderer field_178722_kChild_2;
    public ModelRenderer ticktop;
    public ModelRenderer ticktop_1;
    public ModelRenderer ticktop_2;

    public ModelBerserker() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_78116_cChild_7 = new ModelRenderer(this, 30, 8);
        this.field_78116_cChild_7.setRotationPoint(7.5F, -5.5F, -1.0F);
        this.field_78116_cChild_7.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(field_78116_cChild_7, -0.4363322854042054F, 0.0F, 0.0F);
        this.field_78116_cChild_1 = new ModelRenderer(this, 48, 0);
        this.field_78116_cChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_cChild_1.addBox(-3.0F, -5.0F, -5.0F, 6, 5, 2, 0.0F);
        this.field_178721_jChild = new ModelRenderer(this, 0, 38);
        this.field_178721_jChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178721_jChild.addBox(-3.5999999046325684F, -1.0F, -2.5F, 5, 7, 5, 0.0F);
        this.setRotateAngle(field_178721_jChild, -0.5235987901687622F, 0.0F, 0.0F);
        this.field_178724_iChild_1 = new ModelRenderer(this, 48, 28);
        this.field_178724_iChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178724_iChild_1.addBox(1.5F, 3.0F, 0.5F, 4, 12, 4, 0.0F);
        this.setRotateAngle(field_178724_iChild_1, -0.520457182944709F, 0.0F, 0.0F);
        this.field_78116_cChild_2 = new ModelRenderer(this, 52, 7);
        this.field_78116_cChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_cChild_2.addBox(4.0F, -7.0F, -2.0F, 2, 4, 4, 0.0F);
        this.ticktop = new ModelRenderer(this, 0, 0);
        this.ticktop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ticktop.addBox(-1.5F, 0.0F, 0.0F, 6, 4, 4, 0.0F);
        this.tcik2 = new ModelRenderer(this, 0, 0);
        this.tcik2.setRotationPoint(5.0F, -10.0F, 6.0F);
        this.tcik2.addBox(0.0F, 0.0F, 0.0F, 3, 24, 3, 0.0F);
        this.field_78116_cChild_5 = new ModelRenderer(this, 24, 0);
        this.field_78116_cChild_5.setRotationPoint(6.0F, -5.0F, 1.5F);
        this.field_78116_cChild_5.addBox(0.0F, -1.5F, -3.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(field_78116_cChild_5, 0.0F, 0.6981316804885863F, 0.0F);
        this.dhead = new ModelRenderer(this, 0, 0);
        this.dhead.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.dhead.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.field_178722_kChild_2 = new ModelRenderer(this, 0, 50);
        this.field_178722_kChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178722_kChild_2.addBox(-1.399999976158142F, 9.0F, -4.0F, 5, 3, 5, 0.0F);
        this.ticktop_2 = new ModelRenderer(this, 0, 0);
        this.ticktop_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ticktop_2.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 4, 0.0F);
        this.field_178722_kChild_1 = new ModelRenderer(this, 20, 39);
        this.field_178722_kChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178722_kChild_1.addBox(-0.8999999761581421F, 3.0F, 1.5F, 4, 7, 4, 0.0F);
        this.setRotateAngle(field_178722_kChild_1, -0.5235987901687622F, 0.0F, 0.0F);
        this.field_178723_hChild = new ModelRenderer(this, 44, 16);
        this.field_178723_hChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178723_hChild.addBox(-6.0F, -2.0F, -2.5F, 5, 7, 5, 0.0F);
        this.dbody = new ModelRenderer(this, 0, 0);
        this.dbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dbody.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.field_178720_f = new ModelRenderer(this, 0, 0);
        this.field_178720_f.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178720_f.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.dleftarm = new ModelRenderer(this, 0, 0);
        this.dleftarm.setRotationPoint(7.0F, -4.0F, 0.0F);
        this.dleftarm.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.drightleg = new ModelRenderer(this, 0, 0);
        this.drightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.drightleg.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.field_78115_eChild = new ModelRenderer(this, 0, 15);
        this.field_78115_eChild.setRotationPoint(-3.0F, -7.0F, 0.0F);
        this.field_78115_eChild.addBox(-6.0F, 0.0F, -3.0F, 18, 10, 5, 0.0F);
        this.dleftleg = new ModelRenderer(this, 0, 0);
        this.dleftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.dleftleg.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.field_78115_eChild_1 = new ModelRenderer(this, 0, 28);
        this.field_78115_eChild_1.setRotationPoint(-1.0F, -4.0F, 0.0F);
        this.field_78115_eChild_1.addBox(-5.0F, 7.0F, -2.5F, 12, 9, 5, 0.0F);
        this.tcik1 = new ModelRenderer(this, 0, 0);
        this.tcik1.setRotationPoint(-2.0F, -12.0F, 10.0F);
        this.tcik1.addBox(0.0F, 0.0F, 0.0F, 3, 24, 3, 0.0F);
        this.field_78116_cChild_4 = new ModelRenderer(this, 52, 7);
        this.field_78116_cChild_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_cChild_4.addBox(-6.0F, -7.0F, -2.0F, 2, 4, 4, 0.0F);
        this.drightarm = new ModelRenderer(this, 0, 0);
        this.drightarm.setRotationPoint(-7.0F, -4.0F, 0.0F);
        this.drightarm.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.ticktop_1 = new ModelRenderer(this, 0, 0);
        this.ticktop_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ticktop_1.addBox(0.0F, 0.0F, 0.0F, 6, 4, 4, 0.0F);
        this.field_78116_cChild_3 = new ModelRenderer(this, 30, 8);
        this.field_78116_cChild_3.setRotationPoint(-7.5F, -5.5F, -1.0F);
        this.field_78116_cChild_3.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(field_78116_cChild_3, -0.4363322854042054F, 0.0F, 0.0F);
        this.field_178721_jChild_1 = new ModelRenderer(this, 20, 39);
        this.field_178721_jChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178721_jChild_1.addBox(-3.0999999046325684F, 3.0F, 1.5F, 4, 7, 4, 0.0F);
        this.setRotateAngle(field_178721_jChild_1, -0.5235987901687622F, 0.0F, 0.0F);
        this.field_78116_cChild = new ModelRenderer(this, 0, 0);
        this.field_78116_cChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_cChild.addBox(-4.0F, -8.0F, -3.0F, 8, 8, 7, 0.0F);
        this.field_178724_iChild = new ModelRenderer(this, 44, 16);
        this.field_178724_iChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178724_iChild.addBox(1.0F, -2.0F, -2.5F, 5, 7, 5, 0.0F);
        this.field_178722_kChild = new ModelRenderer(this, 0, 38);
        this.field_178722_kChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178722_kChild.addBox(-1.399999976158142F, -1.0F, -2.5F, 5, 7, 5, 0.0F);
        this.setRotateAngle(field_178722_kChild, -0.5235987901687622F, 0.0F, 0.0F);
        this.field_78116_cChild_6 = new ModelRenderer(this, 24, 0);
        this.field_78116_cChild_6.setRotationPoint(-6.0F, -5.0F, 1.5F);
        this.field_78116_cChild_6.addBox(-4.0F, -1.5F, -3.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(field_78116_cChild_6, 0.0F, -0.6981316804885863F, 0.0F);
        this.field_178721_jChild_2 = new ModelRenderer(this, 0, 50);
        this.field_178721_jChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178721_jChild_2.addBox(-3.5999999046325684F, 9.0F, -4.0F, 5, 3, 5, 0.0F);
        this.field_178723_hChild_1 = new ModelRenderer(this, 48, 28);
        this.field_178723_hChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178723_hChild_1.addBox(-5.5F, 3.0F, 0.5F, 4, 12, 4, 0.0F);
        this.setRotateAngle(field_178723_hChild_1, -0.520457182944709F, 0.0F, 0.0F);
        this.tcik2_1 = new ModelRenderer(this, 0, 0);
        this.tcik2_1.setRotationPoint(-9.0F, -10.0F, 6.0F);
        this.tcik2_1.addBox(0.0F, 0.0F, 0.0F, 3, 24, 3, 0.0F);
        this.dhead.addChild(this.field_78116_cChild_7);
        this.dhead.addChild(this.field_78116_cChild_1);
        this.drightleg.addChild(this.field_178721_jChild);
        this.dleftarm.addChild(this.field_178724_iChild_1);
        this.dhead.addChild(this.field_78116_cChild_2);
        this.tcik1.addChild(this.ticktop);
        this.dhead.addChild(this.field_78116_cChild_5);
        this.dleftleg.addChild(this.field_178722_kChild_2);
        this.tcik2_1.addChild(this.ticktop_2);
        this.dleftleg.addChild(this.field_178722_kChild_1);
        this.drightarm.addChild(this.field_178723_hChild);
        this.dbody.addChild(this.field_78115_eChild);
        this.dbody.addChild(this.field_78115_eChild_1);
        this.dhead.addChild(this.field_78116_cChild_4);
        this.tcik2.addChild(this.ticktop_1);
        this.dhead.addChild(this.field_78116_cChild_3);
        this.drightleg.addChild(this.field_178721_jChild_1);
        this.dhead.addChild(this.field_78116_cChild);
        this.dleftarm.addChild(this.field_178724_iChild);
        this.dleftleg.addChild(this.field_178722_kChild);
        this.dhead.addChild(this.field_78116_cChild_6);
        this.drightleg.addChild(this.field_178721_jChild_2);
        this.drightarm.addChild(this.field_178723_hChild_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.tcik2.render(f5);
        this.dhead.render(f5);
        this.dbody.render(f5);
        this.field_178720_f.render(f5);
        this.dleftarm.render(f5);
        this.drightleg.render(f5);
        this.dleftleg.render(f5);
        this.tcik1.render(f5);
        this.drightarm.render(f5);
        this.tcik2_1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        //super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        this.dleftleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;
        this.drightleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.drightarm.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.dleftarm.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;

        this.dhead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.dhead.rotateAngleX = headPitch * 0.017453292F;
    }
}
