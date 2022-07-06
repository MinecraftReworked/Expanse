package net.bettermc.expanse.entity.client;

import net.bettermc.expanse.entity.custom.MoonRoverEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonRoverRenderer extends GeoEntityRenderer<MoonRoverEntity> {
    public MoonRoverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MoonRoverModel());
    }
}