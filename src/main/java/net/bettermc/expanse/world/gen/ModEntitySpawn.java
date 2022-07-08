package net.bettermc.expanse.world.gen;

import net.bettermc.expanse.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
       // BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.CREATURE,
         //       ModEntities.MARTIAN, 25, 2, 5);



//        SpawnRestrictionAccessor.callRegister(ModEntities.MARTIAN, SpawnRestriction.Location.ON_GROUND,
  //              Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
