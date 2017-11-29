package org.czyz;

class ErrorPrinter implements Printer{
    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
