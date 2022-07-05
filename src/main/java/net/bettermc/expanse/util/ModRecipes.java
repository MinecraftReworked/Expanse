package net.bettermc.expanse.util;

import net.bettermc.expanse.recipe.FurnaceRecipe;
import net.bettermc.expanse.recipe.ModRecipeType;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.registry.Registry;

public class ModRecipes {

    public static ModRecipeType<FurnaceRecipe> FURANCE_RECIPE;

    public static RecipeSerializer<FurnaceRecipe> FURNACE_SERIALIZER;

    public static void register() {

        FURANCE_RECIPE = register(new ModRecipeType<>(new ModIdentifier("furnace")));


        // Recipe Serializers.
        FURNACE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new ModIdentifier("furnace"), new FurnaceRecipe.Serializer());
    }

    private static <T extends ModRecipeType<?>> T register(T recipe) {
        Registry.register(Registry.RECIPE_TYPE, recipe.getId(), recipe);
        return recipe;
    }
}
