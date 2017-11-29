package org.czyz;

import org.czyz.game.*;
import org.czyz.initgame.GameInitializer;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class Main {
    private static Printer printer;

    public static void main(String[] args) {
        setupPrinter(args);
        ResourceBundle labels = setupLanguage();
        GameInitializer gameInitializer = new GameInitializer(printer, labels);
        Settings settings = gameInitializer.setupGame();
        new Game(settings, printer, labels).play();

    }

    private static ResourceBundle setupLanguage() {
        printer.print("Wybierz język| choose language: \npolski: pl\nenglish: en");
        Scanner scanner = new Scanner(System.in);
        String language = scanner.nextLine();
        language = language.toUpperCase();
        printer.print(language);

        if (language.equals("EN")) {
            Locale.setDefault(new Locale("en", "US"));
        } else if(language.equals("PL")){
            Locale.setDefault(new Locale("pl", "PL"));
        }else {
            printer.print("Nieprawidłowy wybór. Ustawiono domyślny język - POLSKI\n");
            Locale.setDefault(new Locale("pl", "PL"));
        }
        return ResourceBundle.getBundle("lang");
    }

    private static void setupPrinter(String[] args) {
        if (args.length > 0) {
            switch (args[0].toUpperCase()) {
                case "E":
                    printer = new ErrorPrinter();
                    break;
                default:
                    printer = new ConsolePrinter();
            }
        } else {
            printer = new ConsolePrinter();
        }
    }
}
