package com.xwm.towergame.entity.EntityShadowHero;

import com.xwm.towergame.entity.EntityTowerMobBase;
import com.xwm.towergame.entity.ai.EntityAIGetTowerEmperorTarget;
import com.xwm.towergame.entity.ai.EntityAINearestAttackableTowerTarget;
import com.xwm.towergame.entity.ai.EntityAIShadowHeroAttack;
import com.xwm.towergame.entity.ai.EntityAITowerHurtByTarget;
import com.xwm.towergame.util.handlers.SoundsHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityShadowHero extends EntityTowerMobBase
{

    public EntityShadowHero(World worldIn, int team, int level, float width, float height) {
        super(worldIn, team, level, width, height);
        this.isImmuneToFire = true;
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 2.0D, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTowerTarget(this, EntityLiving.class, false));
        this.targetTasks.addTask(3, new EntityAITowerHurtByTarget(this, true, new Class[0]));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIGetTowerEmperorTarget(this));
        this.tasks.addTask(1, new EntityAIShadowHeroAttack(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.33000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundsHandler.ENTITY_SHADOWHERO_AMBIENT;
    }

}
