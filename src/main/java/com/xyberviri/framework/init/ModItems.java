package com.xyberviri.framework.init;

import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.items.BlackMushroom;
import com.xyberviri.framework.items.BlueMushroom;
import com.xyberviri.framework.items.Coin;
import com.xyberviri.framework.items.GreenMushroom;
import com.xyberviri.framework.items.PurpleMushroom;
import com.xyberviri.framework.items.RedMushroom;
import com.xyberviri.framework.items.Token;
import com.xyberviri.framework.items.YellowMushroom;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ModItems {
  @ObjectHolder(ModMain.MODID+":token")
  public static Token token;
  @ObjectHolder(ModMain.MODID+":blackmushroom")
  public static BlackMushroom blackmushroom;
  @ObjectHolder(ModMain.MODID+":bluemushroom")
  public static BlueMushroom bluemushroom;
  @ObjectHolder(ModMain.MODID+":greenmushroom")
  public static GreenMushroom greenmushroom;
  @ObjectHolder(ModMain.MODID+":purplemushroom")
  public static PurpleMushroom purplemushroom;
  @ObjectHolder(ModMain.MODID+":redmushroom")
  public static RedMushroom redmushroom;
  @ObjectHolder(ModMain.MODID+":yellowmushroom")
  public static YellowMushroom yellowmushroom;
}