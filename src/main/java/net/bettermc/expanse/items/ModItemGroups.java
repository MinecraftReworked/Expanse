package net.bettermc.expanse.items;

import net.bettermc.expanse.ExpanseMain;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ORES = FabricItemGroupBuilder.build(
        new Identifier(ExpanseMain.MOD_ID, "ores"),
        () -> new ItemStack(ModItems.OSMIUM_INGOT)
    );
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(
        new Identifier(ExpanseMain.MOD_ID, "tools"),
        () -> new ItemStack(ModItems.OSMIUM_PICKAXE)
    );
}
