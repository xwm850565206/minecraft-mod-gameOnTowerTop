package com.xwm.towergame.entity.EntityShadowHero;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityShadowHeroEXRed extends EntityShadowHeroRed
{

    public EntityShadowHeroEXRed(World worldIn) {
        super(worldIn);
        this.level = 2;
        this.width *= level;
        this.height *= level;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
    }
}
