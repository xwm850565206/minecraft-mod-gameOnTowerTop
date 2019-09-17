package com.xwm.towergame.creativeTabs;

import com.xwm.towergame.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTabsTowerGame extends CreativeTabs
{

    public static CreativeTabsTowerGame towerGame = new CreativeTabsTowerGame();

    public CreativeTabsTowerGame()
    {
        super("tower_game");
    }

    @Override
    public ItemStack getTabIconItem() {
        // todo
        return new ItemStack(ItemInit.COIN);
    }
}
