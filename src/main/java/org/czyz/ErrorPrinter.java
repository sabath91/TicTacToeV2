package org.czyz;

import java.util.Formatter;

public class ErrorPrinter implements Printer{
    @Override
    public void print(String message) {
        System.err.println(message);
    }

    @Override
    public void print(Formatter message) {
        System.err.println(message);
    }
}
