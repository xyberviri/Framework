package com.xyberviri.framework.proxy;

import java.io.File;

import com.xyberviri.framework.ModConfig;
import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.blocks.BlockMiner;
import com.xyberviri.framework.client.gui.GuiHandler;
import com.xyberviri.framework.init.ModBlocks;
import com.xyberviri.framework.init.ModItems;
import com.xyberviri.framework.init.ModTileEntities;
import com.xyberviri.framework.items.BlackMushroom;
import com.xyberviri.framework.items.BlueMushroom;
import com.xyberviri.framework.items.Coin;
import com.xyberviri.framework.items.GreenMushroom;
import com.xyberviri.framework.items.PurpleMushroom;
import com.xyberviri.framework.items.RedMushroom;
import com.xyberviri.framework.items.Token;
import com.xyberviri.framework.items.YellowMushroom;
import com.xyberviri.framework.network.NetworkHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class CommonProxy{
	public static Configuration config;
	public static Item token,minerTier1,minerTier2,minerTier3,minerTier4,minerTier5;
	public static Item blackmushroom,bluemushroom,greenmushroom,purplemushroom,redmushroom,yellowmushroom;
	
	 public void preInit(FMLPreInitializationEvent event) {
		 File directory = event.getModConfigurationDirectory();  
		 config = new Configuration(new File(directory.getPath(), ModMain.MODID+".cfg"));
		 ModConfig.readConfig();
		 ModTileEntities.init();
	  }
	  
	 public void init(FMLInitializationEvent e) {
	    NetworkRegistry.INSTANCE.registerGuiHandler(ModMain.instance, new GuiHandler());
	    NetworkHandler.init();
	 }


  
  public void postInit(FMLPostInitializationEvent event) {
	  
  }


  
  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().register(new BlockMiner(1));
    event.getRegistry().register(new BlockMiner(2));
    event.getRegistry().register(new BlockMiner(3));
    event.getRegistry().register(new BlockMiner(4));
    event.getRegistry().register(new BlockMiner(5));
  }

  
  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
	// TODO: Move this to init/Modblocks  
	//Register items from blocks	  
	minerTier1 = new ItemBlock(ModBlocks.minerTierOne);
	minerTier1.setRegistryName(ModBlocks.minerTierOne.getRegistryName());
	event.getRegistry().register(minerTier1);
    
	minerTier2 = new ItemBlock(ModBlocks.minerTierTwo);
	minerTier2.setRegistryName(ModBlocks.minerTierTwo.getRegistryName());
	event.getRegistry().register(minerTier2);
    
    minerTier3 = new ItemBlock(ModBlocks.minerTierThree);
    minerTier3.setRegistryName(ModBlocks.minerTierThree.getRegistryName());
    event.getRegistry().register(minerTier3);  
    
    minerTier4 = new ItemBlock(ModBlocks.minerTierFour);
    minerTier4.setRegistryName(ModBlocks.minerTierFour.getRegistryName());
    event.getRegistry().register(minerTier4);
    
    minerTier5 = new ItemBlock(ModBlocks.minerTierFive);
    minerTier5.setRegistryName(ModBlocks.minerTierFive.getRegistryName());
    event.getRegistry().register(minerTier5);
    
    //Register items that dont have blocks
    token = new Token();
    event.getRegistry().register(token);
    blackmushroom = new BlackMushroom();
    event.getRegistry().register(blackmushroom);
    bluemushroom = new BlueMushroom();
    event.getRegistry().register(bluemushroom);
    greenmushroom = new GreenMushroom();
    event.getRegistry().register(greenmushroom);
    purplemushroom = new PurpleMushroom();
    event.getRegistry().register(purplemushroom);
    redmushroom = new RedMushroom();
    event.getRegistry().register(redmushroom);
    yellowmushroom = new YellowMushroom();
  }

}
