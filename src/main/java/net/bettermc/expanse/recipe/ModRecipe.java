package net.bettermc.expanse.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class ModRecipe implements Recipe<Inventory>, Predicate<ItemStack> {
    protected final List<Ingredient> inputs = new ArrayList<>();
    protected Identifier id;
    protected List<Integer> stackCounts;

    protected ModRecipe(Identifier id) {
        this.id = id;
    }

    protected ModRecipe(Identifier id, Ingredient input) {
        this.id = id;
        this.inputs.add(input);
    }

    protected ModRecipe(Identifier id, List<Ingredient> input, List<Integer> stackCounts) {
        this.id = id;
        this.inputs.addAll(input);
        this.stackCounts = stackCounts;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return true;
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
        defaultedList.addAll(this.inputs);
        return defaultedList;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public List<Integer> getStackCounts() {
        return this.stackCounts;
    }

    @Override
    public boolean test(ItemStack itemStack) {
        for (Ingredient input : this.inputs) {
            if (input.test(itemStack)) {
                return true;
            }
        }
        return false;
    }
}
