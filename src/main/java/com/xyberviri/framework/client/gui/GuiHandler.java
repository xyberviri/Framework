 package com.xyberviri.framework.client.gui;
 
 import javax.annotation.Nullable;

import com.xyberviri.framework.container.ContainerMiner;
import com.xyberviri.framework.tileentity.TileEntityBlockMiner;

import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.common.network.IGuiHandler;
 
 public class GuiHandler implements IGuiHandler {
	 
   public static final int GUI_MINER_CONTAINER_ID = 0;
   public static final int GUI_MARKET_CONTAINER_ID = 1;
   
   @Nullable
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
     TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
     return new ContainerMiner(player, (TileEntityBlockMiner)tileEntity);
   }
 
   
   @Nullable
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
     TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
     return new GuiMiner(player, (TileEntityBlockMiner)tileEntity);
   }
 }