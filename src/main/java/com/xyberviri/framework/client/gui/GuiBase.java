 package com.xyberviri.framework.client.gui;
 
 import com.xyberviri.framework.ModMain;

import net.minecraft.client.gui.inventory.GuiContainer;
 import net.minecraft.inventory.Container;
 import net.minecraft.util.ResourceLocation;
  
 public abstract class GuiBase extends GuiContainer {
   protected ResourceLocation resourceLocation;
   protected int guiWidth;
   protected int guiHeight;
   protected int centerX;
   protected int centerY;
   protected int halfWidth;
   protected int halfHeight;
   
   protected GuiBase(Container inventorySlotsIn, String resourcePath, int guiWidth, int guiHeight) {
     super(inventorySlotsIn);
     this.guiWidth = guiWidth;
     this.guiHeight = guiHeight;
     this.resourceLocation = new ResourceLocation(ModMain.MODID, resourcePath);
   }
   
   public void initGui() {
     this.halfWidth = this.width / 2;
     this.halfHeight = this.height / 2;
     this.centerX = this.halfWidth - this.guiWidth / 2;
     this.centerY = this.halfHeight - this.guiHeight / 2;  
     super.initGui();
   }
   
   protected void drawCenteredHeaderText(String text, int color, int yOffset) {
     drawString(this.mc.fontRenderer, text, this.halfWidth - this.fontRenderer.getStringWidth(text) / 2, this.centerY + yOffset, color);
   }
 }