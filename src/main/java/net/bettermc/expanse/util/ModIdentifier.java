package net.bettermc.expanse.util;

import net.bettermc.expanse.ExpanseMain;
import net.minecraft.util.Identifier;

public class ModIdentifier extends Identifier {
    public ModIdentifier(String path) {
        super(ExpanseMain.MOD_ID, path);
    }
}
