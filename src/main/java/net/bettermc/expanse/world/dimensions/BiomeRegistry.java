package net.bettermc.expanse.world.dimensions;

import net.bettermc.expanse.ExpanseMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BiomeRegistry {
    private static final RegistryKey<Biome> MOON_DESERT = RegistryKey.of(Registry.BIOME_KEY,
            new Identifier(ExpanseMain.MOD_ID, "moon_desert"));
    private static final RegistryKey<Biome> ORBIT = RegistryKey.of(Registry.BIOME_KEY,
            new Identifier(ExpanseMain.MOD_ID, "orbit"));

    private static final RegistryKey<Biome> MARS_DESERT = RegistryKey.of(Registry.BIOME_KEY,
            new Identifier(ExpanseMain.MOD_ID, "mars_desert"));
    private static final RegistryKey<Biome> MARS_ICE_SPIKES = RegistryKey.of(Registry.BIOME_KEY,
            new Identifier(ExpanseMain.MOD_ID, "mars_ice_spikes"));
    private static final RegistryKey<Biome> MARS_ROCKY_PLAINS = RegistryKey.of(Registry.BIOME_KEY,
            new Identifier(ExpanseMain.MOD_ID, "mars_rocky_plains"));
}
