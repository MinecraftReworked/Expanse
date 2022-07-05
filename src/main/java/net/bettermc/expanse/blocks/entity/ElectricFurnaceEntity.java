package net.bettermc.expanse.blocks.entity;

import net.bettermc.expanse.blocks.BlockEntityRegistry;
import net.bettermc.expanse.recipe.CookingRecipe;
import net.bettermc.expanse.recipe.ModRecipe;
import net.bettermc.expanse.screen.ElectricFurnaceScreenHandler;
import net.bettermc.expanse.screen.ModScreenHandlers;
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

public class ElectricFurnaceEntity extends ProcessingMachineEntity{
    public PropertyDelegate propertyDelegate;
    public int MAX_ENERGY = 50;
    public int ENERGY_PER_TICK = 72;

    public ElectricFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.ELECTRIC_FURNACE_ENTITY, blockPos, blockState);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ElectricFurnaceScreenHandler(syncId, inv, this, this.propertyDelegate);
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
    public long getMaxEnergyInsert() {
        return ENERGY_PER_TICK * 32;
    }

    // Input and output.
    @Override
    public int getInventorySize() {
        return 2;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        return slot == 0;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == 1;
    }

    @Override
    public void tick() {
        if (!this.world.isClient) {
            if (this.hasEnergy()) {
                ItemStack input = this.getStack(0);
                if (!input.isEmpty() && (input.getItem().equals(this.inputItem) || this.inputItem == null)) {
                    this.setActive(true);
                    if (this.cookTime < this.cookTimeTotal) {
                        this.cookTime++;
                        this.drainEnergy();

                    } else if (this.outputStack != null) {
                        input.decrement(1);
                        this.finishCooking();

                    } else {
                        CookingRecipe recipe = this.createRecipe(ModRecipes.FURANCE_RECIPE, input, true);
                        if (recipe != null) {
                            this.cookTimeTotal = recipe.getCookTime();
                            this.cookTime = 0;
                        }
                    }
                } else if (this.outputStack != null) {
                    this.stopCooking();
                } else {
                    this.setActive(false);
                }

            }
        }
    }
}
