package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class StartPlayerSetup implements Interaction {

    private Scanner scanner;
    private final ResourceBundle labels;

    StartPlayerSetup(Scanner scanner, ResourceBundle labels) {
        this.scanner = scanner;
        this.labels = labels;
    }

    @Override
    public String action(Consumer<String> onError, Function<String, Boolean> function) {

        String sign = scanner.nextLine();
        sign = sign.toUpperCase();
        if(function.apply(sign)){
            return sign;
        }else {
            onError.accept(labels.getString("OXError"));
            return action(onError, function); //recursion was called 127 - works
        }
    }
}
