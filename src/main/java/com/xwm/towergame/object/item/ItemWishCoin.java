package com.xwm.towergame.object.item;


import com.xwm.towergame.Main;
import com.xwm.towergame.init.GameInit;
import com.xwm.towergame.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemWishCoin extends ItemBase
{
    public ItemWishCoin(String name)
    {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        /*if (GameInit.isGame)
        {
            String info = "";
            info = info + "x: " + GameInit.redPos.getX();
            info = info + "y: " + GameInit.redPos.getY();
            info = info + "z: " + GameInit.redPos.getZ();

            player.sendMessage(new TextComponentString("游戏正在进行中，坐标 " + info));

            return EnumActionResult.FAIL;
        }*/

        if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack))
        {
            GameInit.initGame(worldIn.playerEntities, worldIn, pos);
            GameInit.init();

            itemstack.shrink(1);

            return EnumActionResult.SUCCESS;
        }
        else
            return EnumActionResult.FAIL;
    }

}
