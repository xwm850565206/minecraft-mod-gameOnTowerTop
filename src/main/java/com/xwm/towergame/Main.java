package com.xwm.towergame;

import com.xwm.towergame.proxy.CommonProxy;
import com.xwm.towergame.util.Reference;
import com.xwm.towergame.util.handlers.RegistryHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.PanelUI;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{

    private static Logger logger;

    @Mod.Instance(Reference.MODID)
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries();
        proxy.preInit(event);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegisteries();
        proxy.init(event);
    }

    @EventHandler
    public static void postInit(FMLInitializationEvent event) {

    }
}
