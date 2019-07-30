 package com.xyberviri.framework.tileentity;
 
 import net.minecraft.block.Block;
 import net.minecraft.tileentity.TileEntity; 
 
 public abstract class TileEntityBlockBase extends TileEntity {
	 public TileEntityBlockBase(Block blockType) {
		 this.blockType = blockType; 
	 }
 }