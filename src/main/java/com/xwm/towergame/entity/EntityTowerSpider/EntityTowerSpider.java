package com.xwm.towergame.entity.EntityTowerSpider;

import com.xwm.towergame.entity.EntityTowerMobBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.world.World;

public class EntityTowerSpider extends EntityTowerMobBase
{

    public EntityTowerSpider(World worldIn, int team, int level, float width, float height) {
        super(worldIn, team, level, width, height);
    }

    @Override
    protected void  initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAILeapAtTarget(this, 0.4F));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(55.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
    }
}
