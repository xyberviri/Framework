 package com.xyberviri.framework.init;
 
 import com.xyberviri.framework.ModMain;

import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 public class ModTileEntities
 {
   public static void init() {
     GameRegistry.registerTileEntity(com.xyberviri.framework.tileentity.TileEntityBlockTierOneMiner.class, new ResourceLocation(ModMain.MODID+":miner_tier_1"));
     GameRegistry.registerTileEntity(com.xyberviri.framework.tileentity.TileEntityBlockTierTwoMiner.class, new ResourceLocation(ModMain.MODID+":miner_tier_2"));
     GameRegistry.registerTileEntity(com.xyberviri.framework.tileentity.TileEntityBlockTierThreeMiner.class, new ResourceLocation(ModMain.MODID+":miner_tier_3"));
     GameRegistry.registerTileEntity(com.xyberviri.framework.tileentity.TileEntityBlockMinerTierFour.class, new ResourceLocation(ModMain.MODID+":miner_tier_4"));
     GameRegistry.registerTileEntity(com.xyberviri.framework.tileentity.TileEntityBlockMinerTierFive.class, new ResourceLocation(ModMain.MODID+":miner_tier_5"));
   }
 }
