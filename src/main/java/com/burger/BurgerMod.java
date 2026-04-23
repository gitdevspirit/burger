package com.burger;

import com.burger.gui.BurgerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
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

	// Keybind to open GUI
	private static KeyMapping openGuiKey;

	/**
	 * Create an Identifier with the burger namespace
	 * 
	 * @param path the path for the resource
	 * @return an Identifier with burger namespace
	 */
	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(NAMESPACE, path);
	}

	/**
	 * Initialize the client mod
	 * This is called when the mod is loaded
	 */
	@Override
	public void onInitializeClient() {
		LOGGER.info("Burger v{} is initializing!", VERSION);
		
		// Register keybind (Right Shift by default)
		openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
			"key.burger.open_gui",
			GLFW.GLFW_KEY_RIGHT_SHIFT,
			KeyMapping.Category.MISC
		));
		
		// Register tick event
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		
		// Initialize your features here
		init();
		
		LOGGER.info("Burger loaded successfully! Press RIGHT SHIFT to open the menu.");
	}

	/**
	 * Called every client tick
	 * 
	 * @param client the Minecraft client instance
	 */
	private void tick(Minecraft client) {
		// Check if GUI keybind is pressed
		while (openGuiKey.consumeClick()) {
			if (client.screen == null) {
				client.setScreen(new BurgerScreen(null));
			}
		}
	}

	/**
	 * Initialize all features and modules
	 * Add your feature initialization here
	 */
	private void init() {
		// Initialize config
		com.burger.config.BurgerConfig.load();
		
		// Initialize features
		com.burger.features.WelcomeMessage.init();
		
		// TODO: Add your custom features here
	}
}
