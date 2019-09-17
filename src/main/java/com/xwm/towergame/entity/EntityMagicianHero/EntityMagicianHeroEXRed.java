package com.xwm.towergame.entity.EntityMagicianHero;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityMagicianHeroEXRed extends EntityMagicianHeroRed
{
    public EntityMagicianHeroEXRed(World worldIn) {
        super(worldIn);
        this.level = 2;
        this.width *= level;
        this.height *= level;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(60.0D);
    }
}
