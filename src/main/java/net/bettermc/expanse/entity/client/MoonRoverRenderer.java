package net.bettermc.expanse.entity.client;

import net.bettermc.expanse.entity.custom.MoonRoverEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonRoverRenderer extends GeoEntityRenderer<MoonRoverEntity> {
    public MoonRoverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MoonRoverModel());
    }

    @Override
    public RenderLayer getRenderType(MoonRoverEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                     Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }
}