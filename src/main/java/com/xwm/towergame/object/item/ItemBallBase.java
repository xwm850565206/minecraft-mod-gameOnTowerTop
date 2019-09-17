package com.xwm.towergame.object.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class ItemBallBase extends ItemBase
{
    public int lifespawn = 5;

    public ItemBallBase(String name){
        super(name);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack item = player.getHeldItem(hand);

        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            ItemStack stack = new ItemStack(this, 1);
            Entity entity = new EntityItem(world, player.posX,
                    player.posY + player.getEyeHeight(), player.posZ, stack);
            ((EntityItem)entity).lifespan = this.lifespawn;
            ((EntityItem)entity).setDefaultPickupDelay();
            float angle = (player.rotationYaw / 180F) * 3.141593F; // 水平方向的角度
            float angle2 = (-player.rotationPitch / 180F) * 3.141593F; // 垂直方向的仰角
            final float speed = 2.5f;
            entity.motionY = speed * MathHelper.sin(angle2); // 算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
            entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle); // 根据仰角算出速度在XZ平面上的投影,再正交分解投影
            entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
            world.spawnEntity(entity);
            item.shrink(1);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, item);
    }

    abstract public void use(World worldIn, BlockPos pos);

}
