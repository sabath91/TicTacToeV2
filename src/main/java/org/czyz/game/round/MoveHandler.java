package org.czyz.game.round;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class MoveHandler implements Interaction {
    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();

        if(function.apply(position)){
            return position;
        }else {
            onError.accept("Ruch jest nieprawidłowy proszę podać wartość raz jeszcze");
            return action(message, onError, function); //recursion was called 127 - works
        }
    }
}
