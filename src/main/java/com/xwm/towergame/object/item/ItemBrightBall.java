package com.xwm.towergame.object.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemBrightBall extends ItemBallBase
{
    public ItemBrightBall(String name)
    {
        super(name);
    }

    @Override
    public void use(World worldIn, BlockPos pos) {

        AxisAlignedBB bb = new AxisAlignedBB(pos.getX() - 5.0D, pos.getY() - 5.0D, pos.getZ() - 5.0D, pos.getX()+5.0D, pos.getY()+5.0D, pos.getZ()+5.0D);

        List<Entity> list = worldIn.getEntitiesWithinAABB(EntityLivingBase.class, bb);

        worldIn.playEvent(2005, pos, 10);

        for (Entity entity : list)
        {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, 400, 1));

        }
    }


}
