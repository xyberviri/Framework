package com.xyberviri.framework;



import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;

public class ModConfig {
	private static final String CATEGORY_GENERAL = "general";
	public static int tokenCreationTime = 18000;
	public static int tokensToCreate = 1;
	public static int energyStorage = 20000;
	public static int energyPerTick = 1;
	public static int containUpdateRate=10;
	
    public static void readConfig() {
    	ModMain.logger.info("loading configuration");
        Configuration cfg = ModMain.proxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            FMLLog.log.error("Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
                cfg.load();
            }
        }
        
    }	
	
	private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        tokenCreationTime =  cfg.getInt("tokenCreationTime", CATEGORY_GENERAL, tokenCreationTime, 20, 150000, "How many ticks it takes to generate a new token.");
        tokensToCreate =  cfg.getInt("tokensToCreate", CATEGORY_GENERAL, tokensToCreate, 1, 64, "How many tokens are generated each time a miner complets one cycle.");
        energyStorage =  cfg.getInt("energyStorage", CATEGORY_GENERAL, energyStorage, 1, 1000000, "How much FE a miner is able to store.");
        energyPerTick =  cfg.getInt("energyPerTick", CATEGORY_GENERAL, energyPerTick, 1, 1000000, "How much FE a miner uses per tick.");
        containUpdateRate=cfg.getInt("containUpdateRate", CATEGORY_GENERAL, containUpdateRate, 5, 200, "How many ticks to send updates when a miner GUI is open.");
        //I18n.format("config."+TokenMod.MODID+".tokensToCreate.description", new Object[0])
    }
	/*
    @Mod.EventBusSubscriber
	static class ConfigurationHandler {
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(TokenMod.MODID) && TokenMod.proxy.config.hasChanged()) {
				TokenMod.proxy.config.save();
				readConfig();
			}
		}
	}
	*/
	
}
