package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class WinningSequenceCreator implements Interaction {
    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String length = scanner.nextLine();

        if (function.apply(length)) {
            return length;
        } else {
            onError.accept("Nieprawidłowa wartość. Długośc ciągu musi należeć do przedziału <3, mniejszyWymiarPlanszy>");
            return action(message, onError, function); //recursion was called 127 - works
        }
    }
}
