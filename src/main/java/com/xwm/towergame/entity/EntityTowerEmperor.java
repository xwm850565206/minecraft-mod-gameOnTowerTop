package com.xwm.towergame.entity;

import com.xwm.towergame.entity.ai.EntityAIEmperorMove;
import com.xwm.towergame.entity.ai.EntityAITowerHurtByTarget;
import com.xwm.towergame.util.handlers.SoundsHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTowerEmperor extends EntityTowerMobBase
{

    public EntityTowerEmperor(World worldIn, int team, int level, float width, float height) {
        super(worldIn, team, level, width, height);
    }

    @Override
    protected void initEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAITowerHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAIEmperorMove(this));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundsHandler.ENTITY_EMPEROR_AMBIENT;
    }

}
