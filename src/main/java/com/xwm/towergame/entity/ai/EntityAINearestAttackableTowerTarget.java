package com.xwm.towergame.entity.ai;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerMobBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class EntityAINearestAttackableTowerTarget <T extends EntityLivingBase> extends EntityAINearestAttackableTarget
{

    //private final EntityTowerMobBase taskOwner;
    private final int targetChance;

    public EntityAINearestAttackableTowerTarget( EntityCreature creature, Class<T> classTarget, boolean checkSight)
    {
        this(creature, classTarget, checkSight, false);
    }
    public EntityAINearestAttackableTowerTarget(EntityCreature creature, Class<T> classTarget, boolean checkSight, boolean onlyNearby)
    {
        this(creature, classTarget, 10, checkSight, onlyNearby, (Predicate)null);
    }

    public EntityAINearestAttackableTowerTarget(EntityCreature creature, Class<T> classTarget, int chance, boolean checkSight, boolean onlyNearby, @Nullable final Predicate <? super T > targetSelector)
    {
        super(creature, classTarget, chance, checkSight, onlyNearby, targetSelector);
        this.targetChance = chance;
    }

    @Override
    public boolean shouldExecute()
    {

        if (this.targetClass != EntityPlayer.class && this.targetClass != EntityPlayerMP.class)
        {
            List<T> list = this.taskOwner.world.<T>getEntitiesWithinAABB(this.targetClass, this.getTargetableArea(this.getTargetDistance()));

            if (list.isEmpty()) {
                System.out.println("my attack list is empty");
                return false;
            }
            else {
                Collections.sort(list, this.sorter);
                for(Entity entity : list) {
                    if (!(entity instanceof EntityTowerMobBase)) {
                        this.targetEntity = (EntityLivingBase) entity;
                        //System.out.println("choose normal target");
                        return true;
                    } else if (((EntityTowerMobBase) this.taskOwner).team != ((EntityTowerMobBase) entity).team && !(entity instanceof EntityTowerEmperor)) {
                        this.targetEntity = (EntityLivingBase) entity;
                        //System.out.println("choose towermob target, his team is" + ((EntityTowerMobBase) entity).team + "and my team is" + ((EntityTowerMobBase) this.taskOwner).team);
                        return true;
                    }
                }

                //System.out.println("my attack target cannot be attacked by me");
                return false;


            }
        }
        System.out.println("my attack target is not found");
        return false;
    }
}
