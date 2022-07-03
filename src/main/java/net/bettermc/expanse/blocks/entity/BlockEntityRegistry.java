package net.bettermc.expanse.blocks.entity;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.blocks.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {
    public static BlockEntityType<ElectricFurnaceEntity> ELECTRIC_FURNACE;

    public static void registerAllEntities() {
        ELECTRIC_FURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(ExpanseMain.MOD_ID, "electric_furnace"),
                FabricBlockEntityTypeBuilder.create(ElectricFurnaceEntity::new,
                        BlockRegistry.ELECTRIC_FURNACE).build(null));
    }
}
