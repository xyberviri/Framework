package com.xyberviri.framework.repositories;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.xyberviri.framework.ModConfig;
import com.xyberviri.framework.ModMain;
import com.xyberviri.framework.init.ModItems;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.framework.tweaker")
public class TokenNetwork {
  public static final TokenNetwork INSTANCE = new TokenNetwork();
  private long tokensIssued=0;
  private int ticksToMine=18000;
  private static File location;
  public ItemStack result=ItemStack.EMPTY;
  
  	public TokenNetwork() {
  		this.result = new ItemStack(ModItems.token);
  		this.result.setCount(ModConfig.tokensToCreate);
  		ModMain.logger.info("token");
  	}
  	
  	public void init() {
  		ticksToMine=ModConfig.tokenCreationTime;
  		ModMain.logger.info("Token generation time is currently: {}",ticksToMine);
  	}
  	public ItemStack getReward() {
  		return result.copy();
  	}
  	
  	public int getWorkload(int tier) {
  		return (this.ticksToMine/tier);
  }
  	
  	@ZenMethod
	public static void setOutput(@Nonnull final IItemStack output) {
  		ItemStack craftTweakerInput = toStack(output);
  		if(craftTweakerInput.isEmpty()) {
  			ModMain.logger.info("Attempted to set token miner output to: '{}', but it was not valid ",output);
  		}else {
  			INSTANCE.result=craftTweakerInput;		
  	  		ModMain.logger.info("Setting new mining result to: {} x {}",INSTANCE.result.getDisplayName(),INSTANCE.result.getCount());	
  		}
  		
	}  	

  	
  	private static ItemStack toStack(final IItemStack item)
	{
		if (item == null)
			return ItemStack.EMPTY;
		final Object internal = item.getInternal();
		if (internal == null || !(internal instanceof ItemStack))
			CraftTweakerAPI.getLogger().logError("Not a valid item stack: " + item);
		return internal instanceof ItemStack ? (ItemStack) internal : ItemStack.EMPTY;
	}
//End of class  	
}
