package org.czyz.initgame;

import org.czyz.Interaction;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class BoardDimensionCreator implements Interaction {
    @Override
    public String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function) {
        Scanner scanner = new Scanner(System.in);
        String dim = scanner.nextLine();

        if(function.apply(dim)){
            return dim;
        }else {
            onError.accept("Rozmiar jest nieprawidłowy. Plansza może mieć wymiar z przedziału <3,101> proszę spróbować jeszcze raz");
            return action(message, onError, function); //recursion was called 127 - works
        }
    }
}
