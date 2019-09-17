package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpider;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpiderBlue;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpiderRed;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombie;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieBlue;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieRed;
import com.xwm.towergame.entity.model.ModelTowerSpider;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTowerSpider extends RenderLiving<EntityTowerSpider>
{
    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/spider_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/spider_blue.png");

    public RenderTowerSpider(RenderManager manager) {
        super(manager, new ModelTowerSpider(), 0.5F);
    }

    @Override
    protected void applyRotations(EntityTowerSpider entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityTowerSpider entity)
    {
        if (entity instanceof EntityTowerSpiderRed)
            return TEXTURESRED;
        else if (entity instanceof EntityTowerSpiderBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityTowerSpider entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }

}
