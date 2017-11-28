package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class PlayerCreator implements Interaction {
    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if(function.apply(name)){
            return name;
        }else {
            onError.accept("Nieprawidłowe Imię, Proszę spróbować jeszcze raz");
            return action(message, onError, function);
        }
    }
}
