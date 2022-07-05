package net.bettermc.expanse.blocks;

import net.bettermc.expanse.blocks.entity.BlockEntitySetup;
import net.bettermc.expanse.blocks.entity.ElectricFurnaceEntity;
import net.bettermc.expanse.util.ModIdentifier;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public final class BlockEntityRegistry {
    private static BlockEntityType<BlockEntitySetup> electricFurnaceEntity = null;

    private BlockEntityRegistry() {
    }

    public static BlockEntityType<BlockEntitySetup> getElectricFurnaceEntity() {
        if (electricFurnaceEntity == null) {
            throw new IllegalStateException("This method was queried before the entities were registered.");
        }
        return electricFurnaceEntity;
    }

    public static void registerAllEntities() {
        electricFurnaceEntity = register("furnace_entity", ElectricFurnaceEntity::new,
            BlockRegistry.ELECTRIC_FURNACE
        );

        EnergyStorage.SIDED.registerForBlockEntities(
            (blockEntity, direction) -> ((BlockEntitySetup) blockEntity).getSideEnergyStorage(direction),
            electricFurnaceEntity
        );
    }

    public static <T extends BlockEntity> BlockEntityType<T> register(
        String id,
        FabricBlockEntityTypeBuilder.Factory<T> factory,
        Block... blocks
    ) {
        return Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new ModIdentifier(id),
            FabricBlockEntityTypeBuilder.create(factory, blocks).build(null)
        );
    }
}
