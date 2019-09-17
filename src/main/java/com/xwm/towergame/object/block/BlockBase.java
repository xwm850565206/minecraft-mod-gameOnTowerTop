package com.xwm.towergame.object.block;

import com.xwm.towergame.Main;
import com.xwm.towergame.creativeTabs.CreativeTabsTowerGame;
import com.xwm.towergame.init.BlockInit;
import com.xwm.towergame.init.ItemInit;
import com.xwm.towergame.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{

    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsTowerGame.towerGame);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
