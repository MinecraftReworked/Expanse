package net.bettermc.expanse.recipe;

import net.bettermc.expanse.ExpanseMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(ExpanseMain.MOD_ID, ElectricFurnaceRecipe.Serializer.ID),
                ElectricFurnaceRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(ExpanseMain.MOD_ID, ElectricFurnaceRecipe.Type.ID),
                ElectricFurnaceRecipe.Type.INSTANCE);
    }
}
