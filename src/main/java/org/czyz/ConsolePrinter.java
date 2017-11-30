package org.czyz;

import java.util.Formatter;

public class ConsolePrinter implements Printer{

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(Formatter message) {
        System.out.println(message);
    }

}
