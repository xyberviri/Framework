package com.xyberviri.framework.blocks;

import java.util.List;
import javax.annotation.Nullable;

import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.tileentity.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockMiner extends Block implements ITileEntityProvider {
  private int tier;
  
  public BlockMiner(int tier) {	  
    super(Material.ROCK);											/*TokenMod.logger.info("Creating new block"); */   
    this.tier = tier;												/*TokenMod.logger.info("Setting unlocalized name");*/
    setUnlocalizedName(ModMain.MODID+".miner_tier_" + this.tier); /*TokenMod.logger.info("Setting registry name");*/
    setRegistryName("miner_tier_" + this.tier);						/*TokenMod.logger.info("Setting creative tab");*/
    setCreativeTab(ModMain.creativeTab);							/*TokenMod.logger.info("Setting Hardness");*/
    setHardness(6.0F);
  } 
  
  @Nullable
  public TileEntity createNewTileEntity(World worldIn, int meta) {
    TileEntity result = null;    
    switch (this.tier) {
      case 1:
    	  result = new TileEntityBlockTierOneMiner();
        break;
      case 2:
    	  result = new TileEntityBlockTierTwoMiner();
        break;
      case 3:
    	  result = new TileEntityBlockTierThreeMiner();
        break;
      case 4:
    	  result = new TileEntityBlockMinerTierFour();
        break;
      case 5:
    	  result = new TileEntityBlockMinerTierFive();
        break;
      default:
          result = new TileEntityBlockTierOneMiner();
    }     
    return result;
  }
  

  
  public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
    tooltip.add(I18n.format("item."+ModMain.MODID+".miner_tier_" + this.tier + ".description", new Object[0]));
    super.addInformation(stack, player, tooltip, advanced);
  }
  
  public boolean isFullCube(IBlockState state) { 
	  return false; 
	  }
  
  public boolean isOpaqueCube(IBlockState state) { 
	  return false; 
	  }
  
  public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
    TileEntityBlockMiner minerTileEntity = (TileEntityBlockMiner)worldIn.getTileEntity(pos);
    if (minerTileEntity != null) {
      IItemHandler itemHandler = (IItemHandler)minerTileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
      if (itemHandler != null) {
        for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
          ItemStack stack = itemHandler.getStackInSlot(slot);
          InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
        } 
      }
    } 
    super.breakBlock(worldIn, pos, state);
  }

  
  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    TileEntityBlockMiner minerTileEntity = (TileEntityBlockMiner)worldIn.getTileEntity(pos);
    if (minerTileEntity != null) {
      playerIn.openGui(ModMain.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
    }
    return true;
  }
}
