package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerEmperorBlue;
import com.xwm.towergame.entity.EntityTowerEmperorRed;
import com.xwm.towergame.entity.model.ModelEmperor;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEmperor extends RenderLiving<EntityTowerEmperor>
{
    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/emperor_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/emperor_blue.png");


    public RenderEmperor(RenderManager manager) {
        super(manager, new ModelEmperor(), 0.5F);
    }

    @Override
    protected void applyRotations(EntityTowerEmperor entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityTowerEmperor entity)
    {
        if (entity instanceof EntityTowerEmperorRed)
            return TEXTURESRED;
        else if (entity instanceof EntityTowerEmperorBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityTowerEmperor entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
