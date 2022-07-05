package net.bettermc.expanse.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public final class Placement {
    public static final RegistryEntry<PlacedFeature> OSMIUM_ORE_PLACED = PlacedFeatures.register(
        "osmium_ore_placed",
        FeaturesConfig.OSMIUM_ORE, OreFeature.modifiersWithCount(
            7,
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
        )
    );

    public static final RegistryEntry<PlacedFeature> URANIUM_ORE_PLACED = PlacedFeatures.register(
        "uranium_ore_placed",
        FeaturesConfig.URANIUM_ORE, OreFeature.modifiersWithCount(
            7,
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
        )
    );

    private Placement() {
    }
}
