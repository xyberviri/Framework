 package com.xyberviri.framework.network;
 
 import com.xyberviri.framework.container.ContainerMiner;
import com.xyberviri.framework.network.message.MessageMinerProgress;

import net.minecraft.inventory.Container;
 import net.minecraftforge.fml.client.FMLClientHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 public class HandlerMinerProgress extends Object implements IMessageHandler<MessageMinerProgress, IMessage> {
	 
   public IMessage onMessage(MessageMinerProgress message, MessageContext ctx) {
     NetworkHandler.getThreadListener(ctx).addScheduledTask(() -> {
           Container container = (FMLClientHandler.instance().getClientPlayerEntity()).openContainer;
           if (container instanceof ContainerMiner) {
             ((ContainerMiner)container).setProgress(message.getProgress());
           }
         });     
     return null;
   }
   
 }