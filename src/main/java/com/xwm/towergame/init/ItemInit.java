package com.xwm.towergame.init;

import com.xwm.towergame.object.item.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item COIN = new ItemWishCoin("coin");
    public static final Item UNCOIN = new ItemUnWishCoin("uncoin");

    public static final Item HERO_CARD = new ItemHeroCard("hero_card");
    public static final Item MAGIC_CARD = new ItemMagicCard("magic_card");
    public static final Item MOB_CARD = new ItemMobCard("mob_card");

    public static final Item BRIGHT_BALL = new ItemBrightBall("bright_ball");
    public static final Item METEORITE_BALL = new ItemMeteoriteBall("meteorite_ball");

}
