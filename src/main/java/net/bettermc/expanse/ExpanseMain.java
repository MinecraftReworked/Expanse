package net.bettermc.expanse;

import net.bettermc.expanse.blocks.BlockRegistry;
import net.bettermc.expanse.blocks.entity.BlockEntityRegistry;
import net.bettermc.expanse.items.ItemRegistry;
import net.bettermc.expanse.util.ModRegistries;
import net.bettermc.expanse.villager.VillagerRegistry;
import net.bettermc.expanse.world.dimensions.DimRegistry;
import net.bettermc.expanse.world.dimensions.portal;
import net.bettermc.expanse.world.gen.WorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpanseMain implements ModInitializer {

	public static final String MOD_ID = "expanse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemRegistry.registerModItems();
		BlockRegistry.registerModBlocks();
		BlockEntityRegistry.registerAllEntities();

		ModRegistries.registerModStuffs();
		DimRegistry.register();
		WorldGen.generateModWorldGen();
		portal.registerPortals();
	}
}
