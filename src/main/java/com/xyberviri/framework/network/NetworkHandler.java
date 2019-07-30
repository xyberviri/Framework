 package com.xyberviri.framework.network;
 
 import com.xyberviri.framework.ModMain;

import net.minecraft.client.Minecraft;
 import net.minecraft.util.IThreadListener;
 import net.minecraft.world.WorldServer;
 import net.minecraftforge.fml.common.network.NetworkRegistry;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
  
public class NetworkHandler {
   public static SimpleNetworkWrapper INSTANCE;
   
   public static void init() {
     INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModMain.MODID);
     INSTANCE.registerMessage(HandlerMinerProgress.class, com.xyberviri.framework.network.message.MessageMinerProgress.class, 0, Side.CLIENT);
   }
   
   public static IThreadListener getThreadListener(MessageContext ctx) { 
	   return (ctx.side == Side.SERVER) ? (WorldServer)(ctx.getServerHandler()).player.world : getClientThreadListener(); 
   }

   @SideOnly(Side.CLIENT)
   public static IThreadListener getClientThreadListener() { 
	   return Minecraft.getMinecraft(); 
   }

 }