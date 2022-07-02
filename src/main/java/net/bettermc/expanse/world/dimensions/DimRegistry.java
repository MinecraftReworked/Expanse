package net.bettermc.expanse.world.dimensions;

import net.bettermc.expanse.ExpanseMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class DimRegistry {
    private static final RegistryKey<DimensionOptions> MOON_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ExpanseMain.MOD_ID, "moon"));
    public static RegistryKey<World> MOON_KEY = RegistryKey.of(Registry.WORLD_KEY, MOON_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> MOON_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ExpanseMain.MOD_ID, "moon_type"));

    private static final RegistryKey<DimensionOptions> EARTH_ORBIT_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ExpanseMain.MOD_ID, "earth_orbit"));
    public static RegistryKey<World> EARTH_ORBIT_KEY = RegistryKey.of(Registry.WORLD_KEY, EARTH_ORBIT_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> EARTH_ORBIT_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ExpanseMain.MOD_ID, "earth_orbit_type"));


    public static void register() {
        System.out.println("Registering ModDimensions for " + ExpanseMain.MOD_ID);
    }
}
