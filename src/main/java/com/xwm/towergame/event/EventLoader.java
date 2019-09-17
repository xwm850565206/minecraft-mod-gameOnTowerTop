package com.xwm.towergame.event;

import com.xwm.towergame.entity.EntityMagicianHero.*;
import com.xwm.towergame.entity.EntityRiderHero.*;
import com.xwm.towergame.entity.EntityShadowHero.*;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeleton;
import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerMobBase;
import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeleton;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpider;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombie;
import com.xwm.towergame.init.GameInit;
import com.xwm.towergame.init.ItemInit;
import com.xwm.towergame.object.item.ItemBallBase;
import com.xwm.towergame.util.handlers.SoundsHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ItemStackHolderInjector;
import org.lwjgl.Sys;

import java.util.*;

public class EventLoader
{
    @SubscribeEvent
    public void towerGameOn(TickEvent.WorldTickEvent event)
    {
        if(!GameInit.isGame)
        {
            return;
        }

        World world = event.world;

        if (world.isRemote)
            return;

        GameInit.gameTime++;
        if (GameInit.gameTime > 1e9+7)
            GameInit.gameTime= 40;  //最初的时间可能要有事件触发，所以预留两秒

        ItemStack stack = null;
        EntityItem coin = null;
        if(GameInit.gameTime % 300 == 0)
        {
            stack = new ItemStack(ItemInit.MOB_CARD, 1);
            coin = new EntityItem(world, GameInit.redPos.getX(), GameInit.redPos.getY(), GameInit.redPos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);

            coin = new EntityItem(world, GameInit.bluePos.getX(), GameInit.bluePos.getY(), GameInit.bluePos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);
        }

        if(GameInit.gameTime % 800 == 0)
        {
            stack = new ItemStack(ItemInit.MAGIC_CARD, 1);
            coin = new EntityItem(world, GameInit.redPos.getX(), GameInit.redPos.getY(), GameInit.redPos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);

            coin = new EntityItem(world, GameInit.bluePos.getX(), GameInit.bluePos.getY(), GameInit.bluePos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);
        }

        if(GameInit.gameTime % 1500 == 0)
        {
            stack = new ItemStack(ItemInit.HERO_CARD, 1);
            coin = new EntityItem(world, GameInit.redPos.getX(), GameInit.redPos.getY(), GameInit.redPos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);

            coin = new EntityItem(world, GameInit.bluePos.getX(), GameInit.bluePos.getY(), GameInit.bluePos.getZ(), stack);
            coin.setDefaultPickupDelay();
            world.spawnEntity(coin);
        }

        tpTowerLiving(world);
    }

    @SubscribeEvent
    public void checkGame(LivingDeathEvent event)
    {
        if (!GameInit.isGame)
            return;

        EntityLivingBase entityLivingBase = event.getEntityLiving();

        if (entityLivingBase instanceof EntityTowerEmperor)
        {
            if (((EntityTowerEmperor) entityLivingBase).team == 1)
            {
                GameInit.gameOver("蓝队");
            }
            else
                GameInit.gameOver("红队");
        }
    }

    @SubscribeEvent
    public void entityUplevel(LivingHurtEvent event)
    {
        EntityLivingBase entityLivingBase = event.getEntityLiving();
        World world = entityLivingBase.getEntityWorld();
        BlockPos pos = entityLivingBase.getPosition();
        AxisAlignedBB bb = new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY()+1, pos.getZ()).grow(7.0D);
        List<EntityTowerMobBase> list = world.getEntitiesWithinAABB(EntityTowerMobBase.class, bb);
        List<EntityTowerMobBase> list2 = new ArrayList<EntityTowerMobBase>();

        if (!(entityLivingBase instanceof EntityTowerMobBase))
            return;

        if (!canUpLevel((EntityTowerMobBase) entityLivingBase))
            return;

        int cnt = 0;
        for (EntityTowerMobBase mobBase : list)
        {
            if (mobBase.getClass().equals(entityLivingBase.getClass()))
            {
                list2.add(mobBase);
            }
        }

        for (int i = 0; i < list2.size()/3; i++)
        {
            if (createEXMob(entityLivingBase, pos, world));
            {
                for (int j = i * 3; j < i * 3 + 3; j++) {
                    EntityTowerMobBase mobBase = list2.get(j);
                    mobBase.setDead();
                }
            }
        }
    }

    @SubscribeEvent
    public void checkBall(ItemExpireEvent event) {

        EntityItem entityItem = event.getEntityItem();
        Item item = entityItem.getItem().getItem();


        if (entityItem.getEntityWorld().isRemote)
            return;


        if (item instanceof ItemBallBase)
        {

            ((ItemBallBase) item).use(entityItem.getEntityWorld(), entityItem.getPosition());
            entityItem.setDead();
        }

    }

    public boolean createEXMob(EntityLivingBase mobBase, BlockPos pos, World world)
    {
        EntityTowerMobBase hero = null;
        if (mobBase.getClass().equals(EntityMagicianHeroRed.class) || mobBase.getClass().equals(EntityMagicianHeroBlue.class))
        {
            if (mobBase.getClass().equals(EntityMagicianHeroRed.class))
                hero = new EntityMagicianHeroEXRed(world);
            else
                hero = new EntityMagicianHeroEXBlue(world);

        }
        else if (mobBase.getClass().equals(EntityRiderHeroRed.class) || mobBase.getClass().equals(EntityRiderHeroBlue.class))
        {
            if (mobBase.getClass().equals(EntityRiderHeroRed.class))
                hero = new EntityRiderHeroEXRed(world);
            else
                hero = new EntityRiderHeroEXBlue(world);
        }

        else if (mobBase.getClass().equals(EntityShadowHeroRed.class) || mobBase.getClass().equals(EntityShadowHeroBlue.class))
        {
            if (mobBase.getClass().equals(EntityShadowHeroRed.class))
                hero = new EntityShadowHeroEXRed(world);
            else
                hero = new EntityShadowHeroEXBlue(world);
        }
        else
            return false;

        if (hero == null)
            return false;

        EntityLightningBolt lightning = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true);
        world.addWeatherEffect(lightning);
        hero.setPosition(pos.getX(), pos.getY(), pos.getZ());
        world.spawnEntity(hero);
        return true;
    }

    public boolean canUpLevel(EntityTowerMobBase mobBase)
    {
        if (mobBase instanceof EntityTowerSkeleton)
            return false;
        if (mobBase instanceof EntityTowerSpider)
            return false;
        if (mobBase instanceof EntityTowerZombie)
            return false;
        if (mobBase instanceof EntitySwordSkeleton)
            return false;

        return true;
    }

    public void tpTowerLiving(World world)
    {
        if (!world.isRemote)
        {
            // 红方传送
            AxisAlignedBB bb1 = new AxisAlignedBB(GameInit.tpRedPos1.getX(), GameInit.tpRedPos1.getY(), GameInit.tpRedPos1.getZ(), GameInit.tpRedPos1.getX(), GameInit.tpRedPos1.getY()+1.0D, GameInit.tpRedPos1.getZ()).grow(1.0D);
            List<EntityTowerMobBase> list1 = world.getEntitiesWithinAABB(EntityTowerMobBase.class, bb1);
            for (EntityTowerMobBase mobBase : list1)
            {
                mobBase.setPosition(GameInit.tpRedPos2.getX(), GameInit.tpRedPos2.getY(), GameInit.tpRedPos2.getZ());
            }

            //蓝方传送
            AxisAlignedBB bb2 = new AxisAlignedBB(GameInit.tpBluePos1.getX(), GameInit.tpBluePos1.getY(), GameInit.tpBluePos1.getZ(), GameInit.tpBluePos1.getX(), GameInit.tpBluePos1.getY()+1.0D, GameInit.tpBluePos1.getZ()).grow(1.0D);
            List<EntityTowerMobBase> list2 = world.getEntitiesWithinAABB(EntityTowerMobBase.class, bb2);
            for (EntityTowerMobBase mobBase : list2)
            {
                mobBase.setPosition(GameInit.tpBluePos2.getX(), GameInit.tpBluePos2.getY(), GameInit.tpBluePos2.getZ());
            }
        }
    }
}
