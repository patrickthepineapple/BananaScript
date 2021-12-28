package com.github.unknownbanana.bananascript.number;

import org.jetbrains.annotations.NotNull;

public class NumberConverter {
    public static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static boolean isNumeric(@NotNull String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static int toInt(@NotNull String str) {
        return Integer.parseInt(str);
    }
}
