package com.burger;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for Burger - A fresh Minecraft 1.21 Skyblock client
 * 
 * This is the entry point for the mod. Add your features and modules here!
 */
public class BurgerMod implements ClientModInitializer {
	public static final String NAMESPACE = "burger";
	public static final Logger LOGGER = LoggerFactory.getLogger("Burger");
	public static final ModContainer BURGER_MOD = FabricLoader.getInstance().getModContainer(NAMESPACE).orElseThrow();
	public static final String VERSION = BURGER_MOD.getMetadata().getVersion().getFriendlyString();

	/**
	 * Create an Identifier with the burger namespace
	 * 
	 * @param path the path for the resource
	 * @return an Identifier with burger namespace
	 */
	public static Identifier id(String path) {
		return Identifier.of(NAMESPACE, path);
	}

	/**
	 * Initialize the client mod
	 * This is called when the mod is loaded
	 */
	@Override
	public void onInitializeClient() {
		LOGGER.info("Burger v{} is initializing!", VERSION);
		
		// Register tick event
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		
		// Initialize your features here
		init();
		
		LOGGER.info("Burger loaded successfully!");
	}

	/**
	 * Called every client tick
	 * 
	 * @param client the Minecraft client instance
	 */
	private void tick(Minecraft client) {
		// Add your tick logic here
	}

	/**
	 * Initialize all features and modules
	 * Add your feature initialization here
	 */
	pr
