package com.xwm.towergame.object.item;

import com.xwm.towergame.Main;
import com.xwm.towergame.creativeTabs.CreativeTabsTowerGame;
import com.xwm.towergame.init.ItemInit;
import com.xwm.towergame.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsTowerGame.towerGame);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}