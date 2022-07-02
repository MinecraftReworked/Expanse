package net.bettermc.expanse.world.feature;
import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.blocks.BlockRegistry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class FeaturesConfig {
    public static final List<OreFeatureConfig.Target> OVERWORLD_ENDER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.ENDER_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ENDER_ORE = ConfiguredFeatures.register("ender_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_ENDER_ORES, 9));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + ExpanseMain.MOD_ID);
    }
}
