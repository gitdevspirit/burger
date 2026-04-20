package com.burger.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.burger.BurgerMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Configuration manager for Burger
 * Handles loading and saving config files
 */
public class BurgerConfig {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final File CONFIG_FILE = new File(
		FabricLoader.getInstance().getConfigDir().toFile(),
		"burger.json"
	);
	
	private static BurgerConfig instance;
	
	// Add your config options here
	public boolean exampleFeatureEnabled = true;
	public int exampleValue = 100;
	public String exampleText = "Hello Skyblock!";
	
	/**
	 * Get the config instance
	 * @return config instance
	 */
	public static BurgerConfig getInstance() {
		if (instance == null) {
			load();
		}
		return instance;
	}
	
	/**
	 * Load config from file
	 */
	public static void load() {
		if (CONFIG_FILE.exists()) {
			try (FileReader reader = new FileReader(CONFIG_FILE)) {
				instance = GSON.fromJson(reader, BurgerConfig.class);
				BurgerMod.LOGGER.info("Config loaded successfully!");
			} catch (IOException e) {
				BurgerMod.LOGGER.error("Failed to load config", e);
				instance = new BurgerConfig();
			}
		} else {
			instance = new BurgerConfig();
			save();
		}
	}
	
	/**
	 * Save config to file
	 */
	public static void save() {
		try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
			GSON.toJson(instance, writer);
			BurgerMod.LOGGER.info("Config saved successfully!");
		} catch (IOException e) {
			BurgerMod.LOGGER.error("Failed to save config", e);
		}
	}
}
