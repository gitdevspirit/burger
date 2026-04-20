package com.burger.mixins;

import com.burger.BurgerMod;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Example Mixin: Adds custom behavior to the title screen
 * This mixin logs when the title screen is initialized
 */
@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	
	@Inject(method = "init", at = @At("RETURN"))
	private void onInit(CallbackInfo ci) {
		BurgerMod.LOGGER.info("Title screen initialized! Burger is loaded.");
	}
}
