package net.bettermc.expanse.world.feature;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.blocks.BlockRegistry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class FeaturesConfig {
    public static final List<OreFeatureConfig.Target> OVERWORLD_OSMIUM_ORES = List.of(
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            BlockRegistry.OSMIUM_ORE.getDefaultState()
        ),
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
            BlockRegistry.DEEPSLATE_OSMIUM_ORE.getDefaultState()
        )
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> OSMIUM_ORE =
        ConfiguredFeatures.register("osmium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_OSMIUM_ORES, 9)
        );

    public static final List<OreFeatureConfig.Target> OVERWORLD_URANIUM_ORES = List.of(
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            BlockRegistry.URANIUM_ORE.getDefaultState()
        ),
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
            BlockRegistry.DEEPSLATE_URANIUM_ORE.getDefaultState()
        )
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
        ConfiguredFeatures.register("uranium_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_URANIUM_ORES, 9)
        );

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + ExpanseMain.MOD_ID);
    }
}
