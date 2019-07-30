 package com.xyberviri.framework.network.message;
 
 import io.netty.buffer.ByteBuf;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 
 public class MessageMinerProgress
   implements IMessage
 {
   private float progress;
   
  public MessageMinerProgress() { this.progress = 0.0F; }
 
 
   
   public MessageMinerProgress(float progress) { this.progress = progress; }
 
 
 
   
   public void fromBytes(ByteBuf buf) { this.progress = buf.readFloat(); }
 
 
 
   
  public void toBytes(ByteBuf buf) { buf.writeFloat(this.progress); }
 
 
   
  public float getProgress() { return this.progress; }
 }
