package com.xwm.towergame.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelLlama - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelRiderHero extends ModelBase {
    public ModelRenderer abody;
    public ModelRenderer aleftrearleg;
    public ModelRenderer aleftfrontleg;
    public ModelRenderer arightrearleg;
    public ModelRenderer arightfrontleg;
    public ModelRenderer arightbox;
    public ModelRenderer aleftbox;
    public ModelRenderer amouse;
    public ModelRenderer aface;
    public ModelRenderer arightear;
    public ModelRenderer aleftear;
    public ModelRenderer phead;
    public ModelRenderer pbody;
    public ModelRenderer prightarm;
    public ModelRenderer pleftarm;
    public ModelRenderer prightleg;
    public ModelRenderer pleftleg;
    public ModelRenderer pneck;
    public ModelRenderer pbodypart;

    public ModelRiderHero() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.arightrearleg = new ModelRenderer(this, 29, 29);
        this.arightrearleg.setRotationPoint(-3.5F, 10.0F, 6.0F);
        this.arightrearleg.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.prightleg = new ModelRenderer(this, 4, 40);
        this.prightleg.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.prightleg.addBox(-4.0F, -12.0F, -2.0F, 4, 3, 10, 0.0F);
        this.pbodypart = new ModelRenderer(this, 80, 22);
        this.pbodypart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbodypart.addBox(-5.0F, -12.0F, -1.0F, 10, 16, 1, 0.0F);
        this.pbody = new ModelRenderer(this, 79, 20);
        this.pbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbody.addBox(-4.0F, -12.0F, -2.0F, 8, 14, 4, 0.0F);
        this.aleftear = new ModelRenderer(this, 17, 0);
        this.aleftear.setRotationPoint(0.0F, 7.0F, -6.0F);
        this.aleftear.addBox(1.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F);
        this.phead = new ModelRenderer(this, 0, 0);
        this.phead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phead.addBox(-4.0F, -20.0F, -4.0F, 8, 8, 8, 0.0F);
        this.aface = new ModelRenderer(this, 0, 14);
        this.aface.setRotationPoint(0.0F, 7.0F, -6.0F);
        this.aface.addBox(-4.0F, -16.0F, -6.0F, 8, 18, 6, 0.0F);
        this.pneck = new ModelRenderer(this, 80, 28);
        this.pneck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pneck.addBox(-3.0F, -18.0F, -1.0F, 6, 6, 1, 0.0F);
        this.pleftarm = new ModelRenderer(this, 32, 48);
        this.pleftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.pleftarm.addBox(-1.0F, -14.0F, -2.0F, 4, 12, 4, 0.0F);
        this.aleftfrontleg = new ModelRenderer(this, 29, 29);
        this.aleftfrontleg.setRotationPoint(3.5F, 10.0F, -5.0F);
        this.aleftfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.arightear = new ModelRenderer(this, 17, 0);
        this.arightear.setRotationPoint(0.0F, 7.0F, -6.0F);
        this.arightear.addBox(-4.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F);
        this.arightbox = new ModelRenderer(this, 45, 28);
        this.arightbox.setRotationPoint(-8.5F, 3.0F, 3.0F);
        this.arightbox.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F);
        this.setRotateAngle(arightbox, 0.0F, 1.5707963267948966F, 0.0F);
        this.prightarm = new ModelRenderer(this, 39, 16);
        this.prightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.prightarm.addBox(-3.0F, -14.0F, -2.0F, 4, 12, 4, 0.0F);
        this.amouse = new ModelRenderer(this, -1, 11);
        this.amouse.setRotationPoint(0.0F, 7.0F, -6.0F);
        this.amouse.addBox(-2.0F, -14.0F, -10.0F, 4, 4, 9, 0.0F);
        this.aleftbox = new ModelRenderer(this, 45, 41);
        this.aleftbox.setRotationPoint(5.5F, 3.0F, 3.0F);
        this.aleftbox.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F);
        this.setRotateAngle(aleftbox, 0.0F, 1.5707963267948966F, 0.0F);
        this.arightfrontleg = new ModelRenderer(this, 29, 29);
        this.arightfrontleg.setRotationPoint(-3.5F, 10.0F, -5.0F);
        this.arightfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
        this.abody = new ModelRenderer(this, 29, 0);
        this.abody.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.abody.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(abody, 1.5707963267948966F, 0.0F, 0.0F);
        this.pleftleg = new ModelRenderer(this, 1, 40);
        this.pleftleg.setRotationPoint(4.0F, 0.0F, -6.0F);
        this.pleftleg.addBox(0.0F, 0.0F, -2.0F, 4, 3, 10, 0.0F);
        this.aleftrearleg = new ModelRenderer(this, 29, 29);
        this.aleftrearleg.setRotationPoint(3.5F, 10.0F, 6.0F);
        this.aleftrearleg.addBox(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arightrearleg.render(f5);
        this.prightleg.render(f5);
        this.pbodypart.render(f5);
        this.pbody.render(f5);
        this.aleftear.render(f5);
        this.phead.render(f5);
        this.aface.render(f5);
        this.pneck.render(f5);
        this.pleftarm.render(f5);
        this.aleftfrontleg.render(f5);
        this.arightear.render(f5);
        this.arightbox.render(f5);
        this.prightarm.render(f5);
        this.amouse.render(f5);
        this.aleftbox.render(f5);
        this.arightfrontleg.render(f5);
        this.abody.render(f5);
        this.pleftleg.render(f5);
        this.aleftrearleg.render(f5);
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
        this.aleftfrontleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;
        this.aleftrearleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;

        this.arightfrontleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.arightrearleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.pleftleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;
        this.prightleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;

        this.pleftarm.rotateAngleY = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;
        this.prightarm.rotateAngleY = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;

        this.pneck.rotateAngleY = netHeadYaw * 0.017453292F;
        this.pneck.rotateAngleX = headPitch * 0.017453292F;
        this.phead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.phead.rotateAngleX = headPitch * 0.017453292F;
    }
}
