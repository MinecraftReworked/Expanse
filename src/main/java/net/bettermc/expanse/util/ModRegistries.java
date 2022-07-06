package net.bettermc.expanse.util;

import net.bettermc.expanse.blocks.BlockRegistry;
import net.bettermc.expanse.entity.ModEntities;
import net.bettermc.expanse.entity.custom.MoonRoverEntity;
import net.bettermc.expanse.villager.VillagerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModRegistries {
    public static void registerModStuffs() {

        registerCustomTrades();
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.MOONROVER, MoonRoverEntity.setAttributes());
    }
    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerRegistry.ALIEN_LIBRARIAN, 1,
            factories -> {
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 26),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
            }
        );

        TradeOfferHelper.registerVillagerOffers(VillagerRegistry.ALIEN_LIBRARIAN, 2,
            factories -> {
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 64),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 50),
                    new ItemStack(BlockRegistry.DEEPSLATE_URANIUM_ORE, 1),
                    12, 7, 0.08f
                ));
            }
        );
    }
}
