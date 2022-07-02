package net.bettermc.expanse.world.dimensions;

import net.bettermc.expanse.ExpanseMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class DimRegistry {
    // Moon Dim
    private static final RegistryKey<DimensionOptions> MOON_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ExpanseMain.MOD_ID, "moon"));
    public static RegistryKey<World> MOON_KEY = RegistryKey.of(Registry.WORLD_KEY, MOON_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> MOON_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ExpanseMain.MOD_ID, "moon_type"));
    //Earth Orbit Dimension
    private static final RegistryKey<DimensionOptions> EARTH_ORBIT_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ExpanseMain.MOD_ID, "earth_orbit"));
    public static RegistryKey<World> EARTH_ORBIT_KEY = RegistryKey.of(Registry.WORLD_KEY, EARTH_ORBIT_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> EARTH_ORBIT_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ExpanseMain.MOD_ID, "earth_orbit_type"));

//Mars Dimension
    private static final RegistryKey<DimensionOptions> MARS_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(ExpanseMain.MOD_ID, "mars"));
    public static RegistryKey<World> MARS_KEY = RegistryKey.of(Registry.WORLD_KEY, MARS_DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> MARS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(ExpanseMain.MOD_ID, "mars_type"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + ExpanseMain.MOD_ID);
    }
}
