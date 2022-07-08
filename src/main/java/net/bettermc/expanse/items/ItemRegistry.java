package net.bettermc.expanse.items;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.fluids.ModFluids;
import net.bettermc.expanse.items.custom.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item STEEL_INGOT = registerItem(
        "steel_ingot",
        new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );

    public static final Item DIRTY_STEEL = registerItem(
        "dirty_steel",
        new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item RAW_OSMIUM = registerItem(
        "raw_osmium",
        new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item OSMIUM_INGOT = registerItem(
        "osmium_ingot",
        new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item RAW_URANIUM = registerItem(
        "raw_uranium",
        new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );

    public static final Item RAW_SILVER = registerItem(
            "raw_silver",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item SILVER_INGOT = registerItem(
            "silver_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item RAW_LEAD = registerItem(
            "raw_lead",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item LEAD_INGOT = registerItem(
            "silver_lead",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item RAW_COBALT = registerItem(
            "raw_cobalt",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item COBALT_INGOT = registerItem(
            "cobalt_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item RAW_TITANIUM = registerItem(
            "raw_titanium",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );
    public static final Item TITANIUM_INGOT = registerItem(
            "titanium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.ORES))
    );

    //buckets
    public static final Item OIL_BUCKET = registerItem("oil_bucket",
            new BucketItem(ModFluids.OIL_STILL, new FabricItemSettings().group(ModItemGroups.ORES).maxCount(1)));



    //tools
    public static final Item OSMIUM_PICKAXE = registerItem(
        "osmium_pickaxe",
        new ModPickaxeItem(ModToolMaterial.OSMIUM, 2, 2f,
            new FabricItemSettings().group(ModItemGroups.TOOLS)
        )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ExpanseMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ExpanseMain.MOD_ID);
    }
}
