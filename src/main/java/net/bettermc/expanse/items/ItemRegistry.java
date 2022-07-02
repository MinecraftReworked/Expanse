package net.bettermc.expanse.items;

import net.bettermc.expanse.ExpanseMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item DIRTY_STEEL = registerItem("dirty_steel",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RAW_OSMIUM = registerItem("raw_osmium",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item OSMIUM_INGOT = registerItem("osmium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item RAW_URANIUM = registerItem("raw_uranium",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ExpanseMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ExpanseMain.MOD_ID);
    }

}
