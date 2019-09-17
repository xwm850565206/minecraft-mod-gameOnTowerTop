package com.xwm.towergame.proxy;

import com.xwm.towergame.event.EventLoader;
import com.xwm.towergame.util.ParticlePacket;
import com.xwm.towergame.util.ServerHandlerDummy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
    public static final byte LAVA = 88;
    public static final byte CLOUD = 89;
    public static SimpleNetworkWrapper simpleNetworkWrapper;

    public void preInit(FMLPreInitializationEvent event)
    {
        simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("lava");
        simpleNetworkWrapper.registerMessage(ServerHandlerDummy.class, ParticlePacket.class, LAVA, Side.SERVER);

    }

    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventLoader());
    }
    public void postInit(FMLPostInitializationEvent event){}

    public void registerItemRenderer(Item item, int meta, String id)
    {

    }
}
