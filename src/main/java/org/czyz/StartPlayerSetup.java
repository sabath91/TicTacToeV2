package org.czyz;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class StartPlayerSetup implements Interaction{

    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String sign = scanner.nextLine();
        sign = sign.toUpperCase();
        if(function.apply(sign)){
            return sign;
        }else {
            onError.accept("Nieprawidłowy znak proszę podać X lub O");
            return action(message, onError, function); //recursion was called 127 - works
        }
    }
}
