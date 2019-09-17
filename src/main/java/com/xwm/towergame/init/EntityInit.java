package com.xwm.towergame.init;

import com.xwm.towergame.Main;
import com.xwm.towergame.entity.EntityBerserker;
import com.xwm.towergame.entity.EntityMagicianHero.*;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroBlue;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroEXBlue;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroEXRed;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroRed;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroBlue;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroEXBlue;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroEXRed;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroRed;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeletonBlue;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeletonRed;
import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerEmperorBlue;
import com.xwm.towergame.entity.EntityTowerEmperorRed;
import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeletonBlue;
import com.xwm.towergame.entity.EntityTowerSkeleton.EntityTowerSkeletonRed;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpider;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpiderBlue;
import com.xwm.towergame.entity.EntityTowerSpider.EntityTowerSpiderRed;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombie;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieBlue;
import com.xwm.towergame.entity.EntityTowerZombie.EntityTowerZombieRed;
import com.xwm.towergame.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
    public static void registerEntities()
    {
        // the egg color todo
        registerEntity("rider_hero_red", EntityRiderHeroRed.class, Reference.ENTITY_RIDERHERORED, 50, 11437146, 000000);
        registerEntity("rider_hero_blue", EntityRiderHeroBlue.class, Reference.ENTITY_RIDERHEROBLUE, 50, 11437146, 000000);
        registerEntity("rider_hero_ex_red", EntityRiderHeroEXRed.class, Reference.ENTITY_RIDERHEROEXRED, 50, 11437146, 000000);
        registerEntity("rider_hero_ex_blue", EntityRiderHeroEXBlue.class, Reference.ENTITY_RIDERHEROEXBLUE, 50, 11437146, 000000);

        registerEntity("magician_hero_red", EntityMagicianHeroRed.class, Reference.ENTITY_MAGICIANHERORED, 50, 12500000, 000000);
        registerEntity("magician_hero_blue", EntityMagicianHeroBlue.class, Reference.ENTITY_MAGICIANHEROBLUE, 50, 12500000, 000000);
        registerEntity("magician_hero_ex_red", EntityMagicianHeroEXRed.class, Reference.ENTITY_MAGICIANHEROEXRED, 50, 12500000, 000000);
        registerEntity("magician_hero_ex_blue", EntityMagicianHeroEXBlue.class, Reference.ENTITY_MAGICIANHEROEXBLUE, 50, 12500000, 000000);

        registerEntity("shadow_hero_red", EntityShadowHeroRed.class, Reference.ENTITY_SHADOWHERORED, 50, 14500000, 000000);
        registerEntity("shadow_hero_blue", EntityShadowHeroBlue.class, Reference.ENTITY_SHADOWHEROBLUE, 50, 14500000, 000000);
        registerEntity("shadow_hero_ex_red", EntityShadowHeroEXRed.class, Reference.ENTITY_SHADOWHEROEXRED, 50, 14500000, 000000);
        registerEntity("shadow_hero_ex_blue", EntityShadowHeroEXBlue.class, Reference.ENTITY_SHADOWHEROEXBLUE, 50, 14500000, 000000);

        registerEntity("berserker", EntityBerserker.class, Reference.ENTITY_BERSERKER, 50, 15500000, 000000);

        registerEntity("tower_zombie_red", EntityTowerZombieRed.class, Reference.ENTITY_TOWERZOMBIERED, 50, 16500000, 000000);
        registerEntity("tower_zombie_blue", EntityTowerZombieBlue.class, Reference.ENTITY_TOWERZOMBIEBLUE, 50, 16500000, 000000);

        registerEntity("tower_skeleton_red", EntityTowerSkeletonRed.class, Reference.ENTITY_TOWERSKELETONRED, 50, 17500000, 000000);
        registerEntity("tower_skeleton_blue", EntityTowerSkeletonBlue.class, Reference.ENTITY_TOWERSKELETONBLUE, 50, 17500000, 000000);

        registerEntity("tower_spider_red", EntityTowerSpiderRed.class, Reference.ENTITY_TOWERSPIDERRED, 50, 18500000, 000000);
        registerEntity("tower_spider_blue", EntityTowerSpiderBlue.class, Reference.ENTITY_TOWERSPIDERBLUE, 50, 18500000, 000000);

        registerEntity("sword_skeleton_red", EntitySwordSkeletonRed.class, Reference.ENTITY_SWORDSKELETONRED, 50, 18500000, 000000);
        registerEntity("sword_skeleton_blue", EntitySwordSkeletonBlue.class, Reference.ENTITY_SWORDSKELETONBLUE, 50, 18500000, 000000);

        registerEntity("emperor_red", EntityTowerEmperorRed.class, Reference.ENTITY_EMPERORRED, 50, 19500000, 000000);
        registerEntity("emperor_blue", EntityTowerEmperorBlue.class, Reference.ENTITY_EMPERORBLUE, 50, 19500000, 000000);


    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
