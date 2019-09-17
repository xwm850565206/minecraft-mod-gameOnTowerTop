package com.xwm.towergame.entity.render;

import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHeroBlue;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHeroRed;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHero;
import com.xwm.towergame.entity.model.ModelMagicianHero;
import com.xwm.towergame.entity.model.ModelRiderHero;
import com.xwm.towergame.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMagicianHero extends RenderLiving<EntityMagicianHero> {

    public static final ResourceLocation TEXTURESRED = new ResourceLocation(Reference.MODID + ":textures/entities/magician_hero_red.png");
    public static final ResourceLocation TEXTURESBLUE = new ResourceLocation(Reference.MODID + ":textures/entities/magician_hero_blue.png");
    public static final ResourceLocation TEXTURESRED_ATTACK = new ResourceLocation(Reference.MODID + ":textures/entities/magician_hero_attack_red.png");
    public static final ResourceLocation TEXTURESBLUE_ATTACK = new ResourceLocation(Reference.MODID + ":textures/entities/magician_hero_attack_blue.png");



    public RenderMagicianHero(RenderManager manager) {
        super(manager, new ModelMagicianHero(), 0.5F);
    }


    @Override
    protected void applyRotations(EntityMagicianHero entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMagicianHero entity)
    {
        if (entity instanceof EntityMagicianHeroRed)
            return entity.isAttacking() ? TEXTURESRED_ATTACK : TEXTURESRED;
        else if (entity instanceof EntityMagicianHeroBlue)
            return entity.isAttacking() ? TEXTURESBLUE_ATTACK : TEXTURESBLUE;

        return TEXTURESBLUE;
    }

    @Override
    protected void preRenderCallback(EntityMagicianHero entitylivingbaseIn, float partialTickTime)
    {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scale(entitylivingbaseIn.level, entitylivingbaseIn.level, entitylivingbaseIn.level);
    }
}
