package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHero;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroBlue;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroRed;
import com.xwm.towergame.entity.model.ModelRiderHero;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRiderHero extends RenderLiving<EntityRiderHero> {

    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/rider_hero_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/rider_hero_blue.png");

    public RenderRiderHero(RenderManager manager) {
        super(manager, new ModelRiderHero(), 0.5F);
    }

    @Override
    protected void applyRotations(EntityRiderHero entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityRiderHero entity)
    {
        if (entity instanceof EntityRiderHeroRed)
            return TEXTURESRED;
        else if (entity instanceof EntityRiderHeroBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityRiderHero entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
