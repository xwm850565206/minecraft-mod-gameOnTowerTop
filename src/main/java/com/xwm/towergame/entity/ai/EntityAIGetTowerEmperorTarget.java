package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerMobBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.List;

public class EntityAIGetTowerEmperorTarget extends EntityAIBase {

    private EntityTowerMobBase mob;
    private EntityTowerEmperor entityTarget;

    public EntityAIGetTowerEmperorTarget(EntityTowerMobBase mob)
    {
        this.mob = mob;
    }

    @Override
    public boolean shouldExecute()
    {
        World world = mob.getEntityWorld();
        AxisAlignedBB bb = new AxisAlignedBB(mob.posX, mob.posY, mob.posZ, mob.posX, mob.posY, mob.posZ).grow(mob.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue());
        List<EntityTowerMobBase> list = world.getEntitiesWithinAABB(EntityTowerMobBase.class, bb);
        if (mob.getAttackTarget() == null)
        {
            Boolean flag = true;

            for (EntityTowerMobBase entity : list)
            {
                if (!(entity instanceof EntityTowerEmperor) && entity.team != mob.team)
                {
                    flag = false;
                    break;
                }
            }

            if (!flag)
                return false;

            double minnDist = 99999999;
            for(Entity entity: world.loadedEntityList)
            {
                if (entity instanceof EntityTowerEmperor)
                {
                    if (((EntityTowerEmperor) entity).team != mob.team)
                    {
                        //System.out.println("attack emperor");
                        if (minnDist > mob.getDistance(entity))
                        {
                            minnDist = mob.getDistance(entity);
                            this.entityTarget = (EntityTowerEmperor) entity;
                            //System.out.println("attacking emperor");
                        }
                    }

                    mob.setAttackTarget(this.entityTarget);
                }
            }

            //System.out.println("attack emperor!!!");
            return true;
        }
        else
            return false;
    }

    /*@Override
    public boolean shouldContinueExecuting()
    {
        return this.shouldExecute();
    }

    @Override
    public void startExecuting()
    {
        mob.setAttackTarget(entityTarget);
    }

    public void resetTask()
    {
        entityTarget = null;
        mob.setAttackTarget(null);
    }*/

}
