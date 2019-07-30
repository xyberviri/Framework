 package com.xyberviri.framework.tileentity;
 
 import javax.annotation.Nullable;

import com.xyberviri.framework.ModConfig;
import com.xyberviri.framework.init.ModItems;
import com.xyberviri.framework.itemStackHandler.ItemStackHandlerMiner;
import com.xyberviri.framework.repositories.TokenNetwork;

import net.minecraft.block.Block;
 import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.ITickable;
 import net.minecraftforge.common.capabilities.Capability;
 import net.minecraftforge.items.CapabilityItemHandler;
 
 public abstract class TileEntityBlockMiner extends TileEntityBlockBase implements ITickable {
   private final ItemStackHandlerMiner itemStackHandler;
   private float progress;
   private int tier,work,workLoad;
   
   public TileEntityBlockMiner(Block block, int tier) {
     super(block);
     this.tier = tier;
     this.itemStackHandler = new ItemStackHandlerMiner(1);
   } 
   
   public void update() {
     if (!this.world.isRemote) {
       
       boolean isSpaceInOutput = ((this.itemStackHandler.getStackInSlot(0).getMaxStackSize()-this.itemStackHandler.getStackInSlot(0).getCount()) > (ModConfig.tokensToCreate));
       
       if (this.progress < 100.0F) {
        this.progress = (float)(this.progress + 1.0D / TokenNetwork.INSTANCE.getWorkload(this.tier) * 100.0D);
       }
       
       if (this.progress >= 100.0F && isSpaceInOutput) {
    	   this.itemStackHandler.addToken(0, TokenNetwork.INSTANCE.getReward());
         this.progress = 0.0F;
       } 
     } 
   }
   
   public void readFromNBT(NBTTagCompound compound) {
     this.itemStackHandler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
     if (compound.hasKey("progress")) {
       this.progress = compound.getFloat("progress");
     }
     
     super.readFromNBT(compound);
   }
   
   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
     compound.setTag("ItemStackHandler", this.itemStackHandler.serializeNBT());
     compound.setFloat("progress", this.progress);
     super.writeToNBT(compound);
     return compound;
   }
   
   @Nullable
   public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
     if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
       return (T)this.itemStackHandler;
     }
     return (T)super.getCapability(capability, facing);
   }
 
   public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
     boolean hasCapability = false;     
     if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
       hasCapability = true;
     }     
     return hasCapability;
   }
 
   
   public boolean isUseAbleByPlayer(EntityPlayer playerIn) {
	   return (getWorld().getTileEntity(this.pos) == this && playerIn.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D); 
   } 
   
   public float getProgress() { 
	   return this.progress; 
   }
   
   public void setProgress(float progress) { 
	   this.progress = progress; 
   }
   
 }
