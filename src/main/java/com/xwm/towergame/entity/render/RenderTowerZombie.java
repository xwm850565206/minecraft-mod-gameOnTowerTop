package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombie;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieBlue;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieRed;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTowerZombie extends RenderLiving<EntityTowerZombie>
{
    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/zombie_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/zombie_blue.png");

    public RenderTowerZombie(RenderManager manager) {
        super(manager, new ModelZombie(), 0.5F);
    }

    @Override
    protected void applyRotations(EntityTowerZombie entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityTowerZombie entity)
    {
        if (entity instanceof EntityTowerZombieRed)
            return TEXTURESRED;
        else if (entity instanceof EntityTowerZombieBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityTowerZombie entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }

}
