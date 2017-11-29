package org.czyz;

import org.czyz.game.*;
import org.czyz.initgame.GameInitializer;

class Main {
    private static Printer printer;

    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "E":
                    printer = new ErrorPrinter();
                    break;
                default:
                    printer = new ConsolePrinter();
            }
        }
        else {
            printer = new ConsolePrinter();
        }

        GameInitializer gameInitializer = new GameInitializer(printer);
        Settings settings = gameInitializer.setupGame();
        new Game(settings, printer).play();

    }
}
