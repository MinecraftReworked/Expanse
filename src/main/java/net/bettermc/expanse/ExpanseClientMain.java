package net.bettermc.expanse;

import net.bettermc.expanse.blocks.BlockRegistry;
import net.bettermc.expanse.entity.ModEntities;
import net.bettermc.expanse.entity.client.MoonRoverRenderer;
import net.bettermc.expanse.screen.ElectricFurnaceScreen;
import net.bettermc.expanse.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class ExpanseClientMain implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ELECTRIC_FURNACE, RenderLayer.getCutout());
        ScreenRegistry.register(ModScreenHandlers.ELECTRIC_FURNACE_SCREEN_HANDLER, ElectricFurnaceScreen::new);


        EntityRendererRegistry.register(ModEntities.MOONROVER, MoonRoverRenderer::new);

    }
}
