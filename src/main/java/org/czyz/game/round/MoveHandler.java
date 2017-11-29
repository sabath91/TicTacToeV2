package org.czyz.game.round;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class MoveHandler implements Interaction {

    private Scanner scanner;


    public MoveHandler() {
       scanner = new Scanner(System.in);
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {

        String position = scanner.nextLine();

        if(function.apply(position)){
            return position;
        }else {
            onError.accept("Ruch jest nieprawidłowy proszę podać wartość raz jeszcze");
            return action(onError, function); //recursion was called 127 - works
        }
    }
}
