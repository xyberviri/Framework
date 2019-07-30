 package com.xyberviri.framework.proxy;
 
 import com.xyberviri.framework.init.ModBlocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import net.minecraftforge.fml.relauncher.Side;
 
 @EventBusSubscriber({Side.CLIENT})
 public class ClientProxy extends CommonProxy {
   public void preInit(FMLPreInitializationEvent event) { 
	   super.preInit(event); 
	   }
   
   @SubscribeEvent
   public static void registerModels(ModelRegistryEvent event) {
	   loadModel(minerTier1);
	   loadModel(minerTier2);
	   loadModel(minerTier3);
	   loadModel(minerTier4);
	   loadModel(minerTier5);
	   loadModel(token);
	   loadModel(blackmushroom);
	   loadModel(bluemushroom);
	   loadModel(greenmushroom);
	   loadModel(purplemushroom);
	   loadModel(redmushroom);
	   loadModel(yellowmushroom);
   }
   
   private static void loadModel(Item item) {
	   loadModel(item,0,"inventory");
   }
   private static void loadModel(Item item,int metaData, String variant) {
	   loadModel(item,metaData,item.getRegistryName(), variant);
   }
   private static void loadModel(Item item,int metaData, ResourceLocation resourceLocation, String variant) {
	   ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(resourceLocation, variant));	   
	 //ModelLoader.setCustomModelResourceLocation(token, 0, new ModelResourceLocation(token.getRegistryName(), "inventory"));   
   }
 
 }
