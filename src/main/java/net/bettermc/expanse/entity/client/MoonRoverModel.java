package net.bettermc.expanse.entity.client;

import net.bettermc.expanse.ExpanseMain;
import net.bettermc.expanse.entity.custom.MoonRoverEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonRoverModel extends AnimatedGeoModel<MoonRoverEntity> {
    @Override
    public Identifier getModelResource(MoonRoverEntity object) {
        return new Identifier(ExpanseMain.MOD_ID, "geo/moonrover.geo.json");

    }

    @Override
    public Identifier getTextureResource(MoonRoverEntity object) {
        return new Identifier(ExpanseMain.MOD_ID, "textures/entity/moonrover/moonrover.png");    }

    @Override
    public Identifier getAnimationResource(MoonRoverEntity animatable) {
        return new Identifier(ExpanseMain.MOD_ID, "animations/moonrover.animation.json");
    }
}
