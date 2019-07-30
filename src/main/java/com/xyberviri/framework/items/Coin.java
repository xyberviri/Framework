package com.xyberviri.framework.items;

import java.util.List;
import javax.annotation.Nullable;

import com.xyberviri.framework.ModMain;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Coin extends Item {
	
  public Coin() {
    setUnlocalizedName(ModMain.MODID+".coin");
    setRegistryName(ModMain.MODID,"coin");
    setCreativeTab(ModMain.creativeTab);
    setMaxStackSize(64);
  }
  
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    tooltip.add(I18n.format("item."+ModMain.MODID+"."+getRegistryName().getResourcePath()+".description", new Object[0]));
    super.addInformation(stack, worldIn, tooltip, flagIn);
  }
  
}
