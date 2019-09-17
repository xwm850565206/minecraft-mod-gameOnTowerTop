package com.xwm.towergame.init;

import com.xwm.towergame.object.block.BlockAltar;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MOBALTAR_RED = new BlockAltar("mob_altar_red", BlockAltar.EnumLEVEL.IRON, "red");
    public static final Block MAGICALTAR_RED = new BlockAltar("magic_altar_red", BlockAltar.EnumLEVEL.GOAL, "red");
    public static final Block HEROALTAR_RED = new BlockAltar("hero_altar_red", BlockAltar.EnumLEVEL.DIAMOND, "red");

    public static final Block MOBALTAR_BLUE = new BlockAltar("mob_altar_blue", BlockAltar.EnumLEVEL.IRON, "blue");
    public static final Block MAGICALTAR_BLUE = new BlockAltar("magic_altar_blue", BlockAltar.EnumLEVEL.GOAL, "blue");
    public static final Block HEROALTAR_BLUE = new BlockAltar("hero_altar_blue", BlockAltar.EnumLEVEL.DIAMOND, "blue");


}
