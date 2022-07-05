package net.bettermc.expanse.villager;

import com.google.common.collect.ImmutableSet;
import net.bettermc.expanse.ExpanseMain;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class VillagerRegistry {

    public static final PointOfInterestType ALIEN_LIBRARIAN_POI = registerPOI("alien_librarian_poi", Blocks.LECTERN);

    //SETUP POI BLOCK LATER
    public static final VillagerProfession ALIEN_LIBRARIAN = registerProfession(
        "alienlibrarian",
        RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(ExpanseMain.MOD_ID, "alien_librarian_poi"))
    );

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        VillagerProfession profession =
            VillagerProfessionBuilder.create()
                                     .id(new Identifier(ExpanseMain.MOD_ID, name)).workstation(type)
                                     .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build();

        return Registry.register(
            Registry.VILLAGER_PROFESSION,
            new Identifier(ExpanseMain.MOD_ID, name),
            profession
        );
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(
            Registry.POINT_OF_INTEREST_TYPE,
            new Identifier(ExpanseMain.MOD_ID, name),
            new PointOfInterestType(ImmutableSet.copyOf(block.getStateManager().getStates()), 1, 1)
        );
    }
}