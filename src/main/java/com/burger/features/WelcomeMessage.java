package com.burger.features;

import com.burger.BurgerMod;
import com.burger.config.BurgerConfig;
import com.burger.utils.Utils;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.ChatFormatting;

/**
 * Example feature: Sends a welcome message when joining a server
 */
public class WelcomeMessage {
	
	/**
	 * Initialize the welcome message feature
	 */
	public static void init() {
		BurgerMod.LOGGER.info("Initializing WelcomeMessage feature");
		
		// Register event when player joins a server
		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
			// Send welcome message after a short delay (1 second = 20 ticks)
			new Thread(() -> {
				try {
					Thread.sleep(1000);
					sendWelcomeMessage();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}).start();
		});
	}
	
	/**
	 * Send the welcome message to the player
	 */
	private static void sendWelcomeMessage() {
		if (!BurgerConfig.getInstance().exampleFeatureEnabled) {
			return;
		}
		
		Component message = Component.literal("🍔 ")
			.withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD))
			.append(Component.literal("Welcome to Burger v" + BurgerMod.VERSION + "!")
				.withStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)))
			.append(Component.literal(" 🍔")
				.withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)));
		
		Utils.sendMessage(message);
		
		if (Utils.isOnHypixel()) {
			Utils.sendMessage(Component.literal("You're on Hypixel! Have fun!")
				.withStyle(Style.EMPTY.withColor(ChatFormatting.GREEN)));
		}
	}
}
