package net.bettermc.expanse;

import net.bettermc.expanse.screen.ElectricFuranceScreen;
import net.bettermc.expanse.screen.ElectricFuranceScreenHandler;
import net.bettermc.expanse.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ExpanseClientMain implements ClientModInitializer {
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.ELECTRIC_FURNACE_SCREEN_HANDLER, ElectricFuranceScreen::new);

    }

}
