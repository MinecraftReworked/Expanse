package net.bettermc.expanse.util;

import org.jetbrains.annotations.Contract;

public final class StateConditions {
    private StateConditions() {
    }

    @Contract("null -> fail")
    public static <T> T validateState(T t) {
        if (t == null) {
            throw new IllegalStateException("This method was invoked before its state was ready.");
        }
        return t;
    }
}
