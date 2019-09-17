package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityTowerMobBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class EntityAITowerHurtByTarget extends EntityAIHurtByTarget
{

    public EntityAITowerHurtByTarget(EntityTowerMobBase creatureIn, boolean entityCallsForHelpIn, Class<?>... excludedReinforcementTypes) {
        super(creatureIn, entityCallsForHelpIn, excludedReinforcementTypes);
    }

    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.taskOwner.getRevengeTarget();

        if (this.taskOwner.getRevengeTarget() == null)
            return false;

        if (this.taskOwner.getRevengeTarget() instanceof EntityPlayer)
            return false;

        if (super.shouldExecute())
        {
            if (entitylivingbase instanceof  EntityTowerMobBase)
                return ((EntityTowerMobBase) entitylivingbase).team != ((EntityTowerMobBase)this.taskOwner).team;
            else
                return true;
        }

        return false;
    }

    @Override
    protected void alertOthers()
    {
        double d0 = this.getTargetDistance();

        for (EntityCreature entitycreature : this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), (new AxisAlignedBB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 15.0D, this.taskOwner.posY + 5.0D, this.taskOwner.posZ + 15.0D)).grow(d0, 10.0D, d0)))
        {
            if (this.taskOwner.getRevengeTarget() == null)
                return;

            if (this.taskOwner != entitycreature && entitycreature.getAttackTarget() == null && (!(this.taskOwner instanceof EntityTameable) || ((EntityTameable)this.taskOwner).getOwner() == ((EntityTameable)entitycreature).getOwner()) && !entitycreature.isOnSameTeam(this.taskOwner.getRevengeTarget()))
            {
                if (!(entitycreature instanceof EntityTowerMobBase))
                    return;

                if (!(this.taskOwner.getRevengeTarget() instanceof EntityTowerMobBase))
                {
                    this.setEntityAttackTarget(entitycreature, this.taskOwner.getRevengeTarget());
                    return;
                }

                if (((EntityTowerMobBase)this.taskOwner).team == ((EntityTowerMobBase)this.taskOwner.getRevengeTarget()).team)
                    return;

                if (((EntityTowerMobBase) entitycreature).team == ((EntityTowerMobBase)this.taskOwner).team)
                    this.setEntityAttackTarget(entitycreature, this.taskOwner.getRevengeTarget());
            }
        }
    }
}
