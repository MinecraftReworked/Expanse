package net.bettermc.expanse.recipe;

import net.bettermc.expanse.util.ModRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.google.gson.JsonObject;


public class FurnaceRecipe extends CookingRecipe {
        public FurnaceRecipe(Identifier id, Ingredient input, ItemStack output, short cookTime) {
            super(id, input, output, cookTime);
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return ModRecipes.FURNACE_SERIALIZER;
        }

    public RecipeType<?> getType() {
        return ModRecipes.FURANCE_RECIPE;
    }

public static class Serializer implements RecipeSerializer<FurnaceRecipe> {

    @Override
    public FurnaceRecipe read(Identifier id, JsonObject json) {
        Item item = Registry.ITEM.get(new Identifier(json.get("output").getAsJsonObject().get("item").getAsString()));
        short stackSize = json.get("output").getAsJsonObject().get("count").getAsShort();

        Ingredient input = Ingredient.fromJson(json.get("input"));
        ItemStack output = new ItemStack(item, stackSize);
        short cookTime = json.get("cookTime").getAsShort();
        return new FurnaceRecipe(id, input, output, cookTime);
    }

    @Override
    public FurnaceRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        short cookTime = buf.readShort();
        return new FurnaceRecipe(id, input, output, cookTime);
    }

    @Override
    public void write(PacketByteBuf buf, FurnaceRecipe recipe) {
        recipe.getInputIngredient().write(buf);
        buf.writeItemStack(recipe.getOutput());
        buf.writeShort(recipe.getCookTime());
    }
}
}
