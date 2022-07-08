package net.bettermc.expanse.world.gen;

public class WorldGen {
    public static void generateModWorldGen() {
        OreGen.generateOres();
        ModEntitySpawn.addEntitySpawn();
    }
}
