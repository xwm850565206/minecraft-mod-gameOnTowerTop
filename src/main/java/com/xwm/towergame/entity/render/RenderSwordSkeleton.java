package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHero;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeleton;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeletonBlue;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeletonRed;
import com.xwm.towergame.entity.model.ModelSwordSkeleton;
import com.xwm.towergame.entity.model.ModelTowerSkeleton;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderSwordSkeleton extends RenderLiving<EntitySwordSkeleton>
{
    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/skeleton_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/skeleton_blue.png");

    public RenderSwordSkeleton(RenderManager manager) {
        super(manager, new ModelSwordSkeleton(), 0.5F);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelTowerSkeleton(0.5F, true);
                this.modelArmor = new ModelTowerSkeleton(1.0F, true);
            }
        });
    }

    @Override
    protected void applyRotations(EntitySwordSkeleton entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntitySwordSkeleton entity)
    {
        if (entity instanceof EntitySwordSkeletonRed)
            return TEXTURESRED;
        else if (entity instanceof EntitySwordSkeletonBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntitySwordSkeleton entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
