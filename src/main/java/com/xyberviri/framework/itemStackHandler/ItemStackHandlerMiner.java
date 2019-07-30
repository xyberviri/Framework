 package com.xyberviri.framework.itemStackHandler;
 
 import javax.annotation.Nonnull;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.items.ItemStackHandler;
  
 public class ItemStackHandlerMiner extends ItemStackHandler {
	 
   public ItemStackHandlerMiner(int slots) {
	   super(slots);
   } 
  public ItemStack addToken(int slot, @Nonnull ItemStack stack) { 
	  return super.insertItem(slot, stack, false); 
  }  
   @Nonnull
   public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) { return stack; }
 } 
	