package com.xyberviri.framework;

import com.xyberviri.framework.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTab extends CreativeTabs {
	
  public ModCreativeTab() { 
	  this ("mainTab"); 
	  }
  public ModCreativeTab(String name) { 
	  super(ModMain.MODID + "." + name); 
	  }
  
  public ItemStack createIcon() { 
	  return new ItemStack(ModItems.token); 
  }

  @Override
  public ItemStack getTabIconItem() {
	  return new ItemStack(ModItems.token);
  } 
}
