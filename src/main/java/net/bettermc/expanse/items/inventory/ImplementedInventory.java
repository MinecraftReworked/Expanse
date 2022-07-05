package net.bettermc.expanse.items.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

@FunctionalInterface
public interface ImplementedInventory extends Inventory {
    static ImplementedInventory of(DefaultedList<ItemStack> items) {
        return () -> items;
    }

    static ImplementedInventory create(int slots) {
        return new ImplementedInventory() {
            private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(slots, ItemStack.EMPTY);

            @Override
            public DefaultedList<ItemStack> getItems() {
                return this.inventory;
            }
        };
    }

    @Override
    default void clear() {
        this.getItems().clear();
    }

    DefaultedList<ItemStack> getItems();

    @Override
    default int size() {
        return this.getItems().size();
    }

    @Override
    default boolean isEmpty() {
        for (int i = 0; i < this.size(); i++) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    default ItemStack getStack(int slot) {
        return this.getItems().get(slot);
    }

    @Override
    default ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(this.getItems(), slot, count);
        if (!result.isEmpty()) {
            this.markDirty();
        }
        return result;
    }

    @Override
    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.getItems(), slot);
    }

    @Override
    default void setStack(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }
    }

    @Override
    default void markDirty() {
    }

    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}