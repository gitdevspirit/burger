package com.burger.commands;

import com.burger.gui.BurgerScreen;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandBuildContext;

public class BurgerCommand {
	
	public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandBuildContext context) {
		dispatcher.register(
			ClientCommandManager.literal("burger")
				.executes(BurgerCommand::openGui)
		);
	}
	
	private static int openGui(CommandContext<FabricClientCommandSource> context) {
		Minecraft mc = Minecraft.getInstance();
		mc.execute(() -> mc.setScreen(new BurgerScreen(mc.screen)));
		return Command.SINGLE_SUCCESS;
	}
}
