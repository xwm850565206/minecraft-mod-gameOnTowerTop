package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeleton;
import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeletonBlue;
import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeletonRed;
import com.xwm.towergame.entity.model.ModelTowerSkeleton;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTowerSkeleton extends RenderLiving<EntityTowerSkeleton>
{
    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/skeleton_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/skeleton_blue.png");


    public RenderTowerSkeleton(RenderManager manager)
    {
        super(manager, new ModelTowerSkeleton(), 0.5F);
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

    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

    @Override
    protected void applyRotations(EntityTowerSkeleton entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityTowerSkeleton entity)
    {
        if (entity instanceof EntityTowerSkeletonRed)
            return TEXTURESRED;
        else if (entity instanceof EntityTowerSkeletonBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityTowerSkeleton entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }

}
