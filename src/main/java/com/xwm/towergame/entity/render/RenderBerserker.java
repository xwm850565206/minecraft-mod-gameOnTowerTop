package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityBerserker;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHero;
import com.xwm.towergame.entity.model.ModelBerserker;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBerserker extends RenderLiving<EntityBerserker> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entities/berserker.png");

    public RenderBerserker(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBerserker(), 0.5F);
    }


    @Override
    protected void applyRotations(EntityBerserker entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityBerserker entity) {
        return TEXTURES;
    }

    @Override
    protected void preRenderCallback(EntityBerserker entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
