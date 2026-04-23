package com.burger.gui;

import com.burger.BurgerMod;
import com.burger.config.BurgerConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class BurgerScreen extends Screen {
	private final Screen parent;
	
	public BurgerScreen(Screen parent) {
		super(Component.literal("Burger Menu"));
		this.parent = parent;
	}
	
	@Override
	protected void init() {
		super.init();
		
		int buttonWidth = 200;
		int buttonHeight = 20;
		int x = this.width / 2 - buttonWidth / 2;
		int y = this.height / 2 - 60;
		
		// Title
		// (rendered in render method)
		
		// Toggle Example Feature button
		this.addRenderableWidget(Button.builder(
			Component.literal("Welcome Message: " + (BurgerConfig.getInstance().exampleFeatureEnabled ? "§aON" : "§cOFF")),
			button -> {
				BurgerConfig.getInstance().exampleFeatureEnabled = !BurgerConfig.getInstance().exampleFeatureEnabled;
				BurgerConfig.save();
				button.setMessage(Component.literal("Welcome Message: " + (BurgerConfig.getInstance().exampleFeatureEnabled ? "§aON" : "§cOFF")));
			}
		).bounds(x, y, buttonWidth, buttonHeight).build());
		
		// Example Value button
		this.addRenderableWidget(Button.builder(
			Component.literal("Example Value: " + BurgerConfig.getInstance().exampleValue),
			button -> {
				BurgerConfig.getInstance().exampleValue += 10;
				if (BurgerConfig.getInstance().exampleValue > 200) {
					BurgerConfig.getInstance().exampleValue = 0;
				}
				BurgerConfig.save();
				button.setMessage(Component.literal("Example Value: " + BurgerConfig.getInstance().exampleValue));
			}
		).bounds(x, y + 25, buttonWidth, buttonHeight).build());
		
		// Close button
		this.addRenderableWidget(Button.builder(
			Component.literal("Close"),
			button -> this.onClose()
		).bounds(x, y + 60, buttonWidth, buttonHeight).build());
	}
	
	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
		this.renderBackground(graphics, mouseX, mouseY, partialTick);
		
		// Draw title
		graphics.drawCenteredString(this.font, "🍔 Burger Menu 🍔", this.width / 2, 20, 0xFFFFFF);
		graphics.drawCenteredString(this.font, "v" + BurgerMod.VERSION, this.width / 2, 35, 0x888888);
		
		super.render(graphics, mouseX, mouseY, partialTick);
	}
	
	@Override
	public void onClose() {
		this.minecraft.setScreen(parent);
	}
	
	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
