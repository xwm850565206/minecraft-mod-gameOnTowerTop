package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityAIMagicianHeroAttack extends EntityAIBase
{
    private final EntityMagicianHero parentEntity;
    public int attackTimer;

    public EntityAIMagicianHeroAttack(EntityMagicianHero hero)
    {
        this.parentEntity = hero;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.parentEntity.getAttackTarget() != null;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.attackTimer = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.parentEntity.setAttacking(false);
        attackTimer = 0;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
        double d0 = 64.0D;

        if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
        {
            World world = this.parentEntity.world;
            ++this.attackTimer;

            this.attackTimer %= 10000000; //防止溢出

            /*if (this.attackTimer == 5)
            {
                world.playEvent((EntityPlayer)null, 1015, new BlockPos(this.parentEntity), 0);
            }*/

            if (this.attackTimer % 15 == 0)
            {
                double d1 = 4.0D;
                Vec3d vec3d = this.parentEntity.getLook(1.0F);
                double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
                double d3 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (0.5D + this.parentEntity.posY+5 + (double)(this.parentEntity.height+5 / 2.0F));
                double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
                world.playEvent((EntityPlayer)null, 1016, new BlockPos(this.parentEntity), 0);
                EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, this.parentEntity, d2, d3, d4);
                entitylargefireball.explosionPower = this.parentEntity.getFireballStrength();
                entitylargefireball.posX = this.parentEntity.posX + vec3d.x * 4.0D;
                entitylargefireball.posY = this.parentEntity.posY+5 + (double)(this.parentEntity.height+5 / 2.0F) + 0.5D;
                entitylargefireball.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
                world.spawnEntity(entitylargefireball);
            }
        }

        this.parentEntity.setAttacking(this.attackTimer >= 10);
    }
}

