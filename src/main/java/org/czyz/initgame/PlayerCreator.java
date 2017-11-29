package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class PlayerCreator implements Interaction {

    private Scanner scanner;

    PlayerCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {
        String name = scanner.nextLine();
        if(function.apply(name)){
            return name;
        }else {
            onError.accept("Nieprawidłowe Imię, Proszę spróbować jeszcze raz");
            return action(onError, function);
        }
    }
}
