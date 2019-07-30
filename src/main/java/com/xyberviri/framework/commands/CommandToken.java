package com.xyberviri.framework.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandToken
  extends CommandBase
{
   public String getName() { return "token"; }
   public String getUsage(ICommandSender sender) { return "/token reload"; }


  
  public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
     if (args.length == 0) {
      throw new WrongUsageException(getUsage(sender), new Object[0]);
    }
     if (args[0].equals("reload")) {   
    	 //
    	 // TODO: Add reload config code here
    	 // 	 
       sender.sendMessage(new TextComponentTranslation("commands.tokenmod:reload.success", new Object[0]));
    } else {
       throw new WrongUsageException(getUsage(sender), new Object[0]);
    } 
     
  }
  
}