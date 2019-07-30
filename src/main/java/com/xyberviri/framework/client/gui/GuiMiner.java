 package com.xyberviri.framework.client.gui;
 
 import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.container.ContainerMiner;
import com.xyberviri.framework.tileentity.TileEntityBlockMiner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.resources.I18n;
 import net.minecraft.entity.player.EntityPlayer;
 
 public class GuiMiner extends GuiBase {
   private TileEntityBlockMiner minerTileEntity;
   
   public GuiMiner(EntityPlayer player, TileEntityBlockMiner minerTileEntity) {
     super(new ContainerMiner(player, minerTileEntity), "textures/gui/miner_gui.png", 175, 165);
     this.minerTileEntity = minerTileEntity;
   } 
   
   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
     drawDefaultBackground();
     super.drawScreen(mouseX, mouseY, partialTicks);
     renderHoveredToolTip(mouseX, mouseY);
   } 
   
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
     this.mc.renderEngine.bindTexture(this.resourceLocation);
     drawTexturedModalRect(this.centerX, this.centerY, 0, 0, this.guiWidth, this.guiHeight);
     drawTexturedModalRect(this.centerX + 39, this.centerY + 63, 0, 166, (int)this.minerTileEntity.getProgress(), 4);
     drawCenteredHeaderText(I18n.format("gui."+ModMain.MODID+".miner.header", new Object[0]), 16777215, 10);
     
     if (mouseX >= this.centerX + 39 && mouseX <= this.centerX + 39 + 100 && mouseY >= this.centerY + 63 && mouseY <= this.centerY + 63 + 4)
     {       
       drawHoveringText((int)this.minerTileEntity.getProgress() + "%", mouseX, mouseY);
     }
   } 
   
   protected void keyTyped(char typedChar, int keyCode) throws IOException {
	   
     if (keyCode == Keyboard.KEY_ESCAPE||Minecraft.getMinecraft().gameSettings.keyBindInventory.isActiveAndMatches(keyCode)) {
       this.mc.displayGuiScreen(null);
     }     
     super.keyTyped(typedChar, keyCode);
   }
   
   public boolean doesGuiPauseGame() { return false; }
 }