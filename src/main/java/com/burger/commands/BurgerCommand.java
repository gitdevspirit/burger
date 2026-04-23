package com.burger.commands;

import com.burger.gui.BurgerScreen;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandBuildContext;

public class BurgerCommand {
	
	public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandBuildContext context) {
		dispatcher.register(
			ClientCommandManager.literal("burger")
				.executes(ctx -> {
					Minecraft.getInstance().execute(() -> {
						Minecraft.getInstance().setScreen(new BurgerScreen(Minecraft.getInstance().screen));
					});
					return 1;
				})
		);
	}
}
