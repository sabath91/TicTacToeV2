package org.czyz.game.round;

import org.czyz.Interaction;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class MoveHandler implements Interaction {

    private Scanner scanner;
    private final ResourceBundle labels;


    public MoveHandler(ResourceBundle labels) {
        this.labels = labels;
        scanner = new Scanner(System.in);
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {

        String position = scanner.nextLine();

        if(function.apply(position)){
            return position;
        }else {
            onError.accept(labels.getString("moveError"));
            return action(onError, function); //recursion was called 127 - works
        }
    }
}
