package com.burger.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;

/**
 * General utility methods for the Burger mod
 */
public class Utils {
	
	/**
	 * Get the Minecraft client instance
	 * @return Minecraft client
	 */
	public static Minecraft getClient() {
		return Minecraft.getInstance();
	}
	
	/**
	 * Get the local player
	 * @return LocalPlayer or null if not in game
	 */
	public static LocalPlayer getPlayer() {
		return getClient().player;
	}
	
	/**
	 * Get the current world/level
	 * @return ClientLevel or null if not in game
	 */
	public static ClientLevel getLevel() {
		return getClient().level;
	}
	
	/**
	 * Check if player is in game
	 * @return true if player is in game
	 */
	public static boolean isInGame() {
		return getPlayer() != null && getLevel() != null;
	}
	
	/**
	 * Send a message to the player's chat
	 * @param message the message to send
	 */
	public static void sendMessage(String message) {
		if (getPlayer() != null) {
			getPlayer().displayClientMessage(Component.literal(message), false);
		}
	}
	
	/**
	 * Send a message to the player's chat with formatting
	 * @param message the message component to send
	 */
	public static void sendMessage(Component message) {
		if (getPlayer() != null) {
			getPlayer().displayClientMessage(message, false);
		}
	}
	
	/**
	 * Check if the player is on Hypixel
	 * @return true if on Hypixel
	 */
	public static boolean isOnHypixel() {
		if (!isInGame()) return false;
		
		try {
			String serverBrand = getClient().getCurrentServer().ip;
			return serverBrand != null && serverBrand.toLowerCase().contains("hypixel");
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Check if the player is on Hypixel Skyblock
	 * You can enhance this with scoreboard checking or other methods
	 * @return true if on Skyblock
	 */
	public static boolean isOnSkyblock() {
		if (!isOnHypixel()) return false;
		
		// TODO: Add scoreboard checking or other Skyblock detection
		// For now, just return hypixel check
		return true;
	}
}
