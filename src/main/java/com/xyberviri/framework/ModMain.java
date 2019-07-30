package com.xyberviri.framework;

import java.io.File;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import com.xyberviri.framework.commands.CommandToken;
import com.xyberviri.framework.proxy.CommonProxy;
import com.xyberviri.framework.repositories.TokenNetwork;

@Mod(modid = ModMain.MODID,name = ModMain.NAME,version = ModMain.VERSION,acceptedMinecraftVersions = "[1.12.2]")
public class ModMain
{
  public static final String MODID = "framework";
  public static final String NAME = "Mod Framework";
  public static final String VERSION = "@VERSION@";
  
  @SidedProxy(clientSide = "com.xyberviri.framework.proxy.ClientProxy",serverSide = "com.xyberviri.framework.proxy.CommonProxy")
  public static CommonProxy proxy;  
  
  @Instance(ModMain.MODID)
  public static ModMain instance;
  public static CreativeTabs creativeTab = new ModCreativeTab();
  
  public static Logger logger;
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    logger.info("starting...");
    proxy.preInit(event);
  }
  
  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  
  @EventHandler
  public void postInit(FMLPostInitializationEvent event) { 
	  proxy.postInit(event); 
  }
  
  
  @EventHandler
  public void serverStarting(FMLServerStartingEvent event) {
	  event.registerServerCommand(new CommandToken());
	  TokenNetwork.INSTANCE.init();
  }

  
}
