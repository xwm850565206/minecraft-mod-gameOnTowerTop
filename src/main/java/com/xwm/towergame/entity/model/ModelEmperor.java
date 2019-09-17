package com.xwm.towergame.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelEmperor - xwm
 * Created using Tabula 7.0.0
 */
public class ModelEmperor extends ModelBase {
    public ModelRenderer pneck;
    public ModelRenderer pheadhelmet;
    public ModelRenderer prightarm;
    public ModelRenderer prightleg;
    public ModelRenderer phead;
    public ModelRenderer pbody;
    public ModelRenderer pleftarm;
    public ModelRenderer pleftleg;

    public ModelEmperor() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.pbody = new ModelRenderer(this, 16, 16);
        this.pbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pbody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.pneck = new ModelRenderer(this, 24, 0);
        this.pneck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pneck.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.pleftleg = new ModelRenderer(this, 16, 48);
        this.pleftleg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.pleftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.pleftarm = new ModelRenderer(this, 32, 48);
        this.pleftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.pleftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.phead = new ModelRenderer(this, 0, 0);
        this.phead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.pheadhelmet = new ModelRenderer(this, 32, 0);
        this.pheadhelmet.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.pheadhelmet.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.prightarm = new ModelRenderer(this, 40, 16);
        this.prightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.prightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.prightleg = new ModelRenderer(this, 0, 16);
        this.prightleg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.prightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.pbody.render(f5);
        this.pneck.render(f5);
        this.pleftleg.render(f5);
        this.pleftarm.render(f5);
        this.phead.render(f5);
        this.pheadhelmet.render(f5);
        this.prightarm.render(f5);
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
}
