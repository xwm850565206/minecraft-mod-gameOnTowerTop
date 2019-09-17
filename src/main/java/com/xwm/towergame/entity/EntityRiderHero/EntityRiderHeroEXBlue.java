package com.xwm.towergame.entity.EntityRiderHero;

import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroBlue;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRiderHeroEXBlue extends EntityRiderHeroBlue
{

    public EntityRiderHeroEXBlue(World worldIn) {
        super(worldIn);
        this.level = 2;
        this.width *= level;
        this.height *= level;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
    }
}
