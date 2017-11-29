package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class PlayerCreator implements Interaction {

    private Scanner scanner;
    private final ResourceBundle labels;

    PlayerCreator(Scanner scanner, ResourceBundle labels) {
        this.scanner = scanner;
        this.labels = labels;
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {
        String name = scanner.nextLine();
        if(function.apply(name)){
            return name;
        }else {
            onError.accept(labels.getString("userNameError"));
            return action(onError, function);
        }
    }
}
