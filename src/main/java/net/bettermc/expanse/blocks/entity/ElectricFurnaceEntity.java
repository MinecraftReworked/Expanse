package net.bettermc.expanse.blocks.entity;

import net.bettermc.expanse.blocks.BlockEntityRegistry;
import net.bettermc.expanse.recipe.CookingRecipe;
import net.bettermc.expanse.screen.ElectricFurnaceScreenHandler;
import net.bettermc.expanse.util.ModRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import javax.annotation.Nullable;

public class ElectricFurnaceEntity extends ProcessingMachineEntity {
    public static final int MAX_ENERGY = 50;
    public static final int ENERGY_PER_TICK = 72;
    public PropertyDelegate propertyDelegate = null;

    public ElectricFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.getElectricFurnaceEntity(), blockPos, blockState);
    }

    // Input and output.
    @Override
    public int getInventorySize() {
        return 2;
    }

    @Override
    public long getMaxGeneration() {
        return MAX_ENERGY;
    }

    @Override
    public long getEnergyPerTick() {
        return ENERGY_PER_TICK;
    }

    @Override
    public void tick() {
        assert this.world != null;

        if (this.world.isClient() || !this.hasEnergy()) {
            return;
        }

        ItemStack input = this.getStack(0);

        if (input.isEmpty() || (!input.getItem().equals(this.inputItem) && this.inputItem != null)) {
            if (this.outputStack == null) {
                this.setActive(false);
            } else {
                this.stopCooking();
            }
            return;
        }

        this.setActive(true);

        if (this.cookTime < this.cookTimeTotal) {
            this.cookTime++;
            this.drainEnergy();
            return;
        }
        if (this.outputStack != null) {
            input.decrement(1);
            this.finishCooking();
            return;
        }

        CookingRecipe recipe = this.createRecipe(ModRecipes.getFurnaceRecipe(), input, true);

        if (recipe != null) {
            this.cookTimeTotal = recipe.getCookTime();
            this.cookTime = 0;
        }
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ElectricFurnaceScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public long getMaxEnergyInsert() {
        return (long) ENERGY_PER_TICK << 5;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        return slot == 0;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == 1;
    }
}
