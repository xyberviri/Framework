package com.xyberviri.framework.container;

import com.xyberviri.framework.ModConfig;
import com.xyberviri.framework.network.NetworkHandler;
import com.xyberviri.framework.network.message.MessageMinerProgress;
import com.xyberviri.framework.tileentity.TileEntityBlockMiner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMiner extends Container {
  private TileEntityBlockMiner minerTileEntity;
  private final int MINER_SLOT_X_OFFSET = 82;
  private final int MINER_SLOT_Y_OFFSET = 36;
  
  private final int PLAYER_INVENTORY_X_OFFSET = 9;
  private final int PLAYER_INVENTORY_Y_OFFSET = 85;
  private final int PLAYER_HOT_BAR_Y_OFFSET = 143;
  
  //private int ticksUntilProgressUpdate = 10;
  private int tickCounter = 0;
  
  private EntityPlayer player;
  
  public ContainerMiner(EntityPlayer player, TileEntityBlockMiner minerTileEntity) {
    this.minerTileEntity = minerTileEntity;
    this.player = player;
    IItemHandler handler = minerTileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);    
    this.addSlotToContainer(new SlotItemHandler(handler, 0, MINER_SLOT_X_OFFSET, MINER_SLOT_Y_OFFSET));  
    //Players inventory slots 10 though whatever
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 9; x++) {
        this.addSlotToContainer(new Slot(player.inventory, x + y * 9 + 9, PLAYER_INVENTORY_X_OFFSET + x * 18, PLAYER_INVENTORY_Y_OFFSET + y * 18));
      } 
    } 
    //Player hotbar
    for (int x = 0; x < 9; x++) {
      this.addSlotToContainer(new Slot(player.inventory, x, PLAYER_INVENTORY_X_OFFSET + x * 18, PLAYER_HOT_BAR_Y_OFFSET));
    } 
  }




  
  public boolean canInteractWith(EntityPlayer playerIn) { return this.minerTileEntity.isUseAbleByPlayer(playerIn); }


  
  public void detectAndSendChanges() {
    super.detectAndSendChanges();    //
    //TODO: Maybe change this to !this.world.isRemote ???
    // A crash occurred on this.player being local and there for EntityPlayerMP was not valid.
    // when spamming the itemHandler slot
    this.tickCounter++;
    if (this.tickCounter > ModConfig.containUpdateRate) {
      NetworkHandler.INSTANCE.sendTo(new MessageMinerProgress(this.minerTileEntity.getProgress()), (EntityPlayerMP)this.player);
      this.tickCounter = 0;
    }
    //
    //
    //
  }


  
  public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
    ItemStack resultItemStack = ItemStack.EMPTY;
    Slot slot = (Slot)this.inventorySlots.get(slotIndex);
    
    if (slot != null && slot.getHasStack()) {
      ItemStack stackInSlot = slot.getStack();
      resultItemStack = stackInSlot.copy();
      int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();
      
      if (slotIndex < containerSlots) {
        if (!mergeItemStack(stackInSlot, containerSlots, this.inventorySlots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!mergeItemStack(stackInSlot, 1, containerSlots, false)) {
        return ItemStack.EMPTY;
      } 
      
      if (stackInSlot.getCount() == 0) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      } 
      
      slot.onTake(player, stackInSlot);
    } 
    
    return resultItemStack;
  }

  //
 
  //
  
  public void setProgress(float progress) { this.minerTileEntity.setProgress(progress); }
}
