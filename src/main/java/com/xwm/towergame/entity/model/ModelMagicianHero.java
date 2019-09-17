package com.xwm.towergame.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelMagicianHero extends ModelBase {
    public ModelRenderer pneck;
    public ModelRenderer pbodypart;
    public ModelRenderer prightarm;
    public ModelRenderer prightleg;
    public ModelRenderer phead;
    public ModelRenderer pbody;
    public ModelRenderer pleftarm;
    public ModelRenderer pleftleg;
    public ModelRenderer cloak;
    public ModelRenderer magicTick;
    public ModelRenderer magicTickpart;
    public ModelRenderer whatpart1;
    public ModelRenderer whatpart2;
    public ModelRenderer whatpart3;
    public ModelRenderer whatpart4;

    public ModelMagicianHero() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.phead = new ModelRenderer(this, 0, 0);
        this.phead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.pleftleg = new ModelRenderer(this, 16, 48);
        this.pleftleg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.pleftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.magicTick = new ModelRenderer(this, 65, 40);
        this.magicTick.setRotationPoint(-2.0F, 10.0F, -15.0F);
        this.magicTick.addBox(0.0F, 0.0F, 0.0F, 3, 3, 21, 0.0F);
        this.whatpart4 = new ModelRenderer(this, 20, 96);
        this.whatpart4.setRotationPoint(1.75F, -2.0F, 2.0F);
        this.whatpart4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(whatpart4, -0.20943951023931953F, 0.0F, 0.10471975511965977F);
        this.pleftarm = new ModelRenderer(this, 32, 48);
        this.pleftarm.setRotationPoint(5.0F, 2.5F, 0.0F);
        this.pleftarm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.pneck = new ModelRenderer(this, 24, 0);
        this.pneck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pneck.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.prightarm = new ModelRenderer(this, 40, 16);
        this.prightarm.setRotationPoint(-5.0F, 2.5F, 0.0F);
        this.prightarm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(prightarm, -0.6806784082777886F, 0.0F, 0.0F);
        this.pbody = new ModelRenderer(this, 65, 16);
        this.pbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.pbodypart = new ModelRenderer(this, 0, 32);
        this.pbodypart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbodypart.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 0.0F);
        this.whatpart2 = new ModelRenderer(this, 20, 77);
        this.whatpart2.setRotationPoint(1.75F, -4.0F, 2.0F);
        this.whatpart2.addBox(0.0F, 0.0F, 0.0F, 7, 4, 7, 0.0F);
        this.setRotateAngle(whatpart2, -0.05235987755982988F, 0.0F, 0.02617993877991494F);
        this.cloak = new ModelRenderer(this, 65, 90);
        this.cloak.setRotationPoint(-5.0F, 1.0F, 2.0F);
        this.cloak.addBox(0.0F, 0.0F, 0.0F, 10, 17, 0, 0.0F);
        this.setRotateAngle(cloak, 0.4363323129985824F, 0.0F, 0.0F);
        this.prightleg = new ModelRenderer(this, 0, 16);
        this.prightleg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.prightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.whatpart3 = new ModelRenderer(this, 20, 88);
        this.whatpart3.setRotationPoint(1.75F, -4.0F, 2.0F);
        this.whatpart3.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(whatpart3, -0.10471975511965977F, 0.0F, 0.05235987755982988F);
        this.magicTickpart = new ModelRenderer(this, 65, 70);
        this.magicTickpart.setRotationPoint(-1.0F, -1.0F, -1.0F);
        this.magicTickpart.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
        this.whatpart1 = new ModelRenderer(this, 20, 65);
        this.whatpart1.mirror = true;
        this.whatpart1.setRotationPoint(-5.0F, -10.03F, -5.0F);
        this.whatpart1.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.prightarm.addChild(this.magicTick);
        this.whatpart3.addChild(this.whatpart4);
        this.whatpart1.addChild(this.whatpart2);
        this.whatpart2.addChild(this.whatpart3);
        this.magicTick.addChild(this.magicTickpart);
        this.phead.addChild(this.whatpart1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.phead.render(f5);
        this.pleftleg.render(f5);
        this.pleftarm.render(f5);
        this.pneck.render(f5);
        this.prightarm.render(f5);
        this.pbody.render(f5);
        this.pbodypart.render(f5);
        this.cloak.render(f5);
        this.prightleg.render(f5);
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

        this.pleftleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F) * 1.4F * limbSwingAmount;
        this.prightleg.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.prightarm.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.magicTick.rotateAngleX = MathHelper.cos(limbSwing*0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.pneck.rotateAngleY = netHeadYaw * 0.017453292F;
        this.pneck.rotateAngleX = headPitch * 0.017453292F;
        this.phead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.phead.rotateAngleX = headPitch * 0.017453292F;
    }
}
