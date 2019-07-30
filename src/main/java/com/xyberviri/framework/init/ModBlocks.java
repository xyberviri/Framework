package com.xyberviri.framework.init;

import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.blocks.BlockMiner;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ModBlocks {  
  @ObjectHolder(ModMain.MODID+":miner_tier_1")
  public static BlockMiner minerTierOne;
  
  @ObjectHolder(ModMain.MODID+":miner_tier_2")
  public static BlockMiner minerTierTwo;
  
  @ObjectHolder(ModMain.MODID+":miner_tier_3")
  public static BlockMiner minerTierThree;
  
  @ObjectHolder(ModMain.MODID+":miner_tier_4")
  public static BlockMiner minerTierFour;
  
  @ObjectHolder(ModMain.MODID+":miner_tier_5")
  public static BlockMiner minerTierFive;
}
