package net.bettermc.expanse.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class Placement {
    public static final RegistryEntry<PlacedFeature> ENDER_ORE_PLACED = PlacedFeatures.register("ender_ore_placed",
            FeaturesConfig.ENDER_ORE, OreFeature.modifiersWithCount(7,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
}
