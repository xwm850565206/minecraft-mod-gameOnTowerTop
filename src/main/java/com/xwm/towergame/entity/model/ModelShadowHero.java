package com.xwm.towergame.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelShadowHero - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelShadowHero extends ModelBase {
    public ModelRenderer pneck;
    public ModelRenderer pbodypart;
    public ModelRenderer phelmet;
    public ModelRenderer prightarm;
    public ModelRenderer prightleg;
    public ModelRenderer phead;
    public ModelRenderer pbody;
    public ModelRenderer pleftarm;
    public ModelRenderer pleftleg;
    public ModelRenderer pcloth;
    public ModelRenderer pcloakleft;
    public ModelRenderer pcloakright;
    public ModelRenderer pcloakfront1;
    public ModelRenderer pcloakfront2;
    public ModelRenderer pcloakrear;
    public ModelRenderer pcloaktop1;
    public ModelRenderer pcloaktop2;

    public ModelShadowHero() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.prightarm = new ModelRenderer(this, 40, 16);
        this.prightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.prightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.pbodypart = new ModelRenderer(this, 0, 0);
        this.pbodypart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbodypart.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 0.0F);
        this.phead = new ModelRenderer(this, 0, 0);
        this.phead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.pleftarm = new ModelRenderer(this, 32, 48);
        this.pleftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.pleftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.pcloakfront2 = new ModelRenderer(this, 20, 95);
        this.pcloakfront2.setRotationPoint(-9.0F, 0.0F, -5.0F);
        this.pcloakfront2.addBox(0.0F, 0.0F, 0.0F, 6, 20, 1, 0.0F);
        this.pcloaktop1 = new ModelRenderer(this, 40, 70);
        this.pcloaktop1.setRotationPoint(-8.0F, -2.0F, -4.0F);
        this.pcloaktop1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
        this.pcloakfront1 = new ModelRenderer(this, 0, 95);
        this.pcloakfront1.setRotationPoint(3.0F, 0.0F, -5.0F);
        this.pcloakfront1.addBox(0.0F, 0.0F, 0.0F, 6, 20, 1, 0.0F);
        this.pneck = new ModelRenderer(this, 24, 0);
        this.pneck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pneck.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.phelmet = new ModelRenderer(this, 40, 0);
        this.phelmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phelmet.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.4F);
        this.pcloakright = new ModelRenderer(this, 20, 65);
        this.pcloakright.setRotationPoint(-9.0F, 0.0F, -4.0F);
        this.pcloakright.addBox(0.0F, 0.0F, 0.0F, 1, 20, 8, 0.0F);
        this.pcloaktop2 = new ModelRenderer(this, 70, 70);
        this.pcloaktop2.setRotationPoint(4.0F, -0.2F, -4.0F);
        this.pcloaktop2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 8, 0.0F);
        this.prightleg = new ModelRenderer(this, 0, 16);
        this.prightleg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.prightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.pbody = new ModelRenderer(this, 16, 16);
        this.pbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.pcloth = new ModelRenderer(this, 16, 32);
        this.pcloth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pcloth.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.pleftleg = new ModelRenderer(this, 16, 48);
        this.pleftleg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.pleftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.pcloakrear = new ModelRenderer(this, 40, 90);
        this.pcloakrear.setRotationPoint(-8.0F, 0.0F, 4.0F);
        this.pcloakrear.addBox(0.0F, 0.0F, 0.0F, 17, 20, 1, 0.0F);
        this.pcloakleft = new ModelRenderer(this, 1, 65);
        this.pcloakleft.setRotationPoint(8.0F, 0.0F, -4.0F);
        this.pcloakleft.addBox(0.0F, 0.0F, 0.0F, 1, 20, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.prightarm.render(f5);
        this.pbodypart.render(f5);
        this.phead.render(f5);
        this.pleftarm.render(f5);
        this.pcloakfront2.render(f5);
        this.pcloaktop1.render(f5);
        this.pcloakfront1.render(f5);
        this.pneck.render(f5);
        this.phelmet.render(f5);
        this.pcloakright.render(f5);
        this.pcloaktop2.render(f5);
        this.prightleg.render(f5);
        this.pbody.render(f5);
        this.pcloth.render(f5);
        this.pleftleg.render(f5);
        this.pcloakrear.render(f5);
        this.pcloakleft.render(f5);
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

        this.pneck.rotateAngleY = netHeadYaw * 0.017453292F;
        this.pneck.rotateAngleX = headPitch * 0.017453292F;
        this.phead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.phead.rotateAngleX = headPitch * 0.017453292F;
    }
}
