package net.bettermc.expanse.world.dimensions;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

public class portal {
    //temp class
     public static void registerPortals() {
            CustomPortalBuilder.beginPortal()
                    .frameBlock(Blocks.END_STONE)
                    .destDimID(DimRegistry.MOON_KEY.getValue())
                    .tintColor(150, 200, 60)
                    .registerPortal();
        }
    }
