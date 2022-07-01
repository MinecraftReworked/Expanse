package net.bettermc.expanse.items;

import net.bettermc.expanse.ExpanseMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item ENDER_INGOT = registerItem("ender_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item RAW_ENDER = registerItem("raw_ender",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ExpanseMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ExpanseMain.MOD_ID);
    }

}
