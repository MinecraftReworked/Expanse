package net.bettermc.expanse.blocks.custom;

import net.bettermc.expanse.blocks.entity.ElectricFurnaceEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class ElectricFurnaceBlock extends MachineBlockSetup {

    public ElectricFurnaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean useFacing() {
        return true;
    }

    @Override
    protected boolean useLit() {
        return true;
    }

    @Override
    public ElectricFurnaceEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ElectricFurnaceEntity(pos, state);
    }
}
