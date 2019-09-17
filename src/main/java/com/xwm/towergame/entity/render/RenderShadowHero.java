package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHero;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroBlue;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroRed;
import com.xwm.towergame.entity.model.ModelShadowHero;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderShadowHero extends RenderLiving<EntityShadowHero> {

    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/shadow_hero_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/shadow_hero_blue.png");

    public RenderShadowHero(RenderManager manager) {
        super(manager, new ModelShadowHero(), 0.5F);
    }

    @Override
    protected void applyRotations(EntityShadowHero entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityShadowHero entity)
    {
        if (entity instanceof EntityShadowHeroRed)
            return TEXTURESRED;
        else if (entity instanceof EntityShadowHeroBlue)
            return TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityShadowHero entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
