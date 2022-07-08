package net.bettermc.expanse.items;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.entity.ModEntities;
import net.bettermc.expanse.fluids.ModFluids;
import net.bettermc.expanse.items.custom.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
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
            new BucketItem(ModFluids.OIL_STILL, new FabricItemSettings().group(ModItemGroups.ORES).maxCount(1))
    );
    //FOOD
    public static final Item CANNED_APPLE = registerItem("canned_apple",
            new Item(new FabricItemSettings().group(ModItemGroups.TOOLS).food(ModFoodComponents.CANNED_APPLE)));



    //EGGS
    public static final Item MOONROVER_SPAWN_EGG = registerItem("moonrover_spawn_egg",
            new SpawnEggItem(ModEntities.MOONROVER,0x948e8d, 0x3b3635,
                    new FabricItemSettings().group(ModItemGroups.ORES)));


    //tools
    public static final Item OSMIUM_PICKAXE = registerItem(
        "osmium_pickaxe",
        new ModPickaxeItem(ModToolMaterial.OSMIUM, 2, 2f,
            new FabricItemSettings().group(ModItemGroups.TOOLS)
        )
    );
    // ARMOR

    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));
    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));


    public static final Item OXYGEN_MASK = registerItem("oxygen_mask",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));
    public static final Item OXYGEN_TANK = registerItem("oxygen_tank",
            new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroups.TOOLS)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ExpanseMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ExpanseMain.MOD_ID);
    }
}
