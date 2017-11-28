package org.czyz;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class PlayerCreator implements Interaction {
    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if(function.apply(name)){
            message.accept(name);
        }else {
            onError.accept("Nieprawidłowe Imię, Proszę spróbować jeszcze raz");
            return action(message, onError, function);
        }
        scanner.close();
        return name;
    }
}