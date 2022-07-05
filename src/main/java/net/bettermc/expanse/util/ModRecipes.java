package net.bettermc.expanse.util;

import net.bettermc.expanse.recipe.FurnaceRecipe;
import net.bettermc.expanse.recipe.ModRecipeType;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.registry.Registry;

public class ModRecipes {

    private static ModRecipeType<FurnaceRecipe> furnaceRecipe = null;
    private static RecipeSerializer<FurnaceRecipe> furnaceSerializer = null;

    public static ModRecipeType<FurnaceRecipe> getFurnaceRecipe() {
        return StateConditions.validateState(furnaceRecipe);
    }

    public static RecipeSerializer<FurnaceRecipe> getFurnaceSerializer() {
        return StateConditions.validateState(furnaceSerializer);
    }

    public static void register() {
        furnaceRecipe = register(new ModRecipeType<>(new ModIdentifier("furnace")));

        // Recipe Serializers.
        furnaceSerializer = Registry.register(
            Registry.RECIPE_SERIALIZER,
            new ModIdentifier("furnace"),
            new FurnaceRecipe.Serializer()
        );
    }

    private static <T extends ModRecipeType<?>> T register(T recipe) {
        Registry.register(Registry.RECIPE_TYPE, recipe.getId(), recipe);
        return recipe;
    }
}
