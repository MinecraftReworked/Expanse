package net.bettermc.expanse.world.gen;

import net.bettermc.expanse.world.feature.Placement;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class OreGen {
    public static void generateOres() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            Placement.OSMIUM_ORE_PLACED.getKey().orElseThrow()
        );

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            Placement.URANIUM_ORE_PLACED.getKey().orElseThrow()
        );
    }
}
