package com.xwm.towergame.util.handlers;

import com.xwm.towergame.entity.EntityBerserker;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHeroBlue;
import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHeroRed;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroBlue;
import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHeroRed;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroBlue;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHeroRed;
import com.xwm.towergame.entity.EntitySwordSkeleton.EntitySwordSkeleton;
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
import com.xwm.towergame.entity.render.*;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        //骑士红
        RenderingRegistry.registerEntityRenderingHandler(EntityRiderHeroRed.class, new IRenderFactory<EntityRiderHeroRed>() {
            @Override
            public Render<? super EntityRiderHeroRed> createRenderFor(RenderManager manager) {
                return new RenderRiderHero(manager);
            }
        });
        //骑士蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityRiderHeroBlue.class, new IRenderFactory<EntityRiderHeroBlue>() {
            @Override
            public Render<? super EntityRiderHeroBlue> createRenderFor(RenderManager manager) {
                return new RenderRiderHero(manager);
            }
        });

        // 法师红
        RenderingRegistry.registerEntityRenderingHandler(EntityMagicianHeroRed.class, new IRenderFactory<EntityMagicianHeroRed>() {
            @Override
            public Render<? super EntityMagicianHeroRed> createRenderFor(RenderManager manager) {
                return new RenderMagicianHero(manager);
            }
        });

        //法师蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityMagicianHeroBlue.class, new IRenderFactory<EntityMagicianHeroBlue>() {
            @Override
            public Render<? super EntityMagicianHeroBlue> createRenderFor(RenderManager manager) {
                return new RenderMagicianHero(manager);
            }
        });

        //刺客红
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowHeroRed.class, new IRenderFactory<EntityShadowHeroRed>() {
            @Override
            public Render<? super EntityShadowHeroRed> createRenderFor(RenderManager manager) {
                return new RenderShadowHero(manager);
            }
        });

        //刺客蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowHeroBlue.class, new IRenderFactory<EntityShadowHeroBlue>() {
            @Override
            public Render<? super EntityShadowHeroBlue> createRenderFor(RenderManager manager) {
                return new RenderShadowHero(manager);
            }
        });


        //狂战士
        RenderingRegistry.registerEntityRenderingHandler(EntityBerserker.class, new IRenderFactory<EntityBerserker>() {
            @Override
            public Render<? super EntityBerserker> createRenderFor(RenderManager manager) {
                return new RenderBerserker(manager);
            }
        });

        //僵尸红
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerZombieRed.class, new IRenderFactory<EntityTowerZombieRed>() {
            @Override
            public Render<? super EntityTowerZombieRed> createRenderFor(RenderManager manager) {
                return new RenderTowerZombie(manager);
            }
        });

        //僵尸蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerZombieBlue.class, new IRenderFactory<EntityTowerZombieBlue>() {
            @Override
            public Render<? super EntityTowerZombieBlue> createRenderFor(RenderManager manager) {
                return new RenderTowerZombie(manager);
            }
        });

        //骷髅射手红
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerSkeletonRed.class, new IRenderFactory<EntityTowerSkeletonRed>() {
            @Override
            public Render<? super EntityTowerSkeletonRed> createRenderFor(RenderManager manager) {
                return new RenderTowerSkeleton(manager);
            }
        });

        //骷髅射手蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerSkeletonBlue.class, new IRenderFactory<EntityTowerSkeletonBlue>() {
            @Override
            public Render<? super EntityTowerSkeletonBlue> createRenderFor(RenderManager manager) {
                return new RenderTowerSkeleton(manager);
            }
        });

        //蜘蛛红
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerSpiderRed.class, new IRenderFactory<EntityTowerSpiderRed>() {
            @Override
            public Render<? super EntityTowerSpiderRed> createRenderFor(RenderManager manager) {
                return new RenderTowerSpider(manager);
            }
        });

        //蜘蛛蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerSpiderBlue.class, new IRenderFactory<EntityTowerSpiderBlue>() {
            @Override
            public Render<? super EntityTowerSpiderBlue> createRenderFor(RenderManager manager) {
                return new RenderTowerSpider(manager);
            }
        });

        //骷髅剑士红
        RenderingRegistry.registerEntityRenderingHandler(EntitySwordSkeletonRed.class, new IRenderFactory<EntitySwordSkeletonRed>() {
            @Override
            public Render<? super EntitySwordSkeletonRed> createRenderFor(RenderManager manager) {
                return new RenderSwordSkeleton(manager);
            }
        });

        //骷髅剑士蓝
        RenderingRegistry.registerEntityRenderingHandler(EntitySwordSkeletonBlue.class, new IRenderFactory<EntitySwordSkeletonBlue>() {
            @Override
            public Render<? super EntitySwordSkeletonBlue> createRenderFor(RenderManager manager) {
                return new RenderSwordSkeleton(manager);
            }
        });

        //皇帝红
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerEmperorRed.class, new IRenderFactory<EntityTowerEmperorRed>() {
            @Override
            public Render<? super EntityTowerEmperorRed> createRenderFor(RenderManager manager) {
                return new RenderEmperor(manager);
            }
        });

        //皇帝蓝
        RenderingRegistry.registerEntityRenderingHandler(EntityTowerEmperorBlue.class, new IRenderFactory<EntityTowerEmperorBlue>() {
            @Override
            public Render<? super EntityTowerEmperorBlue> createRenderFor(RenderManager manager) {
                return new RenderEmperor(manager);
            }
        });
    }
}
