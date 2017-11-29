package org.czyz;

public class ErrorPrinter implements Printer{
    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
