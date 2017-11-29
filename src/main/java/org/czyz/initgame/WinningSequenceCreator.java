package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class WinningSequenceCreator implements Interaction {

    private Scanner scanner;

    WinningSequenceCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {
        String length = scanner.nextLine();

        if (function.apply(length)) {
            return length;
        } else {
            onError.accept("Nieprawidłowa wartość. Długośc ciągu musi należeć do przedziału <3, mniejszyWymiarPlanszy>");
            return action(onError, function); //recursion was called 127 - works
        }
    }
}
