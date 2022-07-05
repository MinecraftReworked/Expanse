package net.bettermc.expanse.screen;

import net.bettermc.expanse.ExpanseMain;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE_SCREEN_HANDLER =
        ScreenHandlerRegistry.registerSimple(
            new Identifier(ExpanseMain.MOD_ID, "electric_furnace"),
            ElectricFurnaceScreenHandler::new
        );
}

