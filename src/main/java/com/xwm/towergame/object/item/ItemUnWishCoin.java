package com.xwm.towergame.object.item;

import com.xwm.towergame.init.GameInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemUnWishCoin extends ItemBase
{

    public ItemUnWishCoin(String name) {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack))
        {
            GameInit.gameOver("红队和蓝队");

            itemstack.shrink(1);

            return EnumActionResult.SUCCESS;
        }
        else
            return EnumActionResult.FAIL;
    }

}
