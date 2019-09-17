package com.xwm.towergame.entity;

import com.xwm.towergame.entity.ai.EntityAIGetTowerEmperorTarget;
import com.xwm.towergame.entity.ai.EntityAINearestAttackableTowerTarget;
import com.xwm.towergame.entity.ai.EntityAITowerHurtByTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTowerMobBase extends EntityMob
{
    public final int team;

    public int level = 1;

    public EntityTowerMobBase(World worldIn, int team, int level, float width, float height) {

        super(worldIn);
        this.team = team;
        this.level = level;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
    }


    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTowerTarget(this, EntityLiving.class, true));
        this.targetTasks.addTask(3, new EntityAITowerHurtByTarget(this, true, new Class[0]));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIGetTowerEmperorTarget(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.33000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        Entity entity = source.getTrueSource();

        if (! (entity instanceof EntityTowerMobBase))
            return super.attackEntityFrom(source, amount);
        else
        {
            if (this.team == ((EntityTowerMobBase) entity).team)
            {
                return super.attackEntityFrom(source, 0);
            }
            else
                return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public float getEyeHeight()
    {
        return height-0.4F;
    }
}
