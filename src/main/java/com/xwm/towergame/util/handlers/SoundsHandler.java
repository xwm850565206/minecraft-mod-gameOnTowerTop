package com.xwm.towergame.util.handlers;

import com.xwm.towergame.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler
{
    public static SoundEvent ENTITY_RIDERHERO_AMBIENT, ENTITY_RIDERHERO_HURT;
    public static SoundEvent ENTITY_SHADOWHERO_AMBIENT;//, ENTITY_SHADOWHERO_HURT, ENTITY_SHADOWHERO_DEATH;
    public static SoundEvent ENTITY_MAGICIAN_AMBIENT, ENTITY_MAGICIAN_DEATH;

    public static SoundEvent ENTITY_BERSERKER_AMBIENT, ENTITY_BERSERKER_HURT, ENTITY_BERSERKER_DEATH;
    public static SoundEvent ENTITY_EMPEROR_AMBIENT;

    public static SoundEvent ON_GAME;

    public static void registerSounds()
    {
        ON_GAME = registerSound("fighting");

        ENTITY_EMPEROR_AMBIENT = registerSound("entity.emperor.ambient");

        ENTITY_RIDERHERO_AMBIENT = registerSound("entity.rider_hero.ambient");
        ENTITY_RIDERHERO_HURT = registerSound("entity.rider_hero.hurt");
        //ENTITY_RIDERHERO_DEATH = registerSound("entity.rider_hero.death");

        ENTITY_SHADOWHERO_AMBIENT = registerSound("entity.shadow_hero.ambient");
        //ENTITY_SHADOWHERO_HURT = registerSound("entity.shadow_hero.hurt");
        //ENTITY_SHADOWHERO_DEATH = registerSound("entity.shadow_hero.death");


        ENTITY_MAGICIAN_AMBIENT = registerSound("entity.magician_hero.ambient");
        ENTITY_MAGICIAN_DEATH = registerSound("entity.magician_hero.death");

        ENTITY_BERSERKER_AMBIENT = registerSound("entity.berserker.ambient");
        ENTITY_BERSERKER_HURT = registerSound("entity.berserker.hurt");
        ENTITY_BERSERKER_DEATH = registerSound("entity.berserker.death");

    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);

        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
