package net.bettermc.expanse.entity;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.entity.custom.MoonRoverEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class ModEntities {
    public static final EntityType<MoonRoverEntity> MOONROVER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ExpanseMain.MOD_ID, "moonrover"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoonRoverEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());
}


