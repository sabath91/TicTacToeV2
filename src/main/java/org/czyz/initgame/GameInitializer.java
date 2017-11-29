package org.czyz.initgame;

import org.czyz.*;
import org.czyz.game.*;

import java.util.ResourceBundle;
import java.util.Scanner;

public class GameInitializer {
    private BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;
    private Player startingPlayer;
    private WinningSequenceLength winningSequenceLength;
    private Printer printer;
    private Scanner scanner;
    private final ResourceBundle labels;

    public GameInitializer(Printer printer, ResourceBundle labels) {
        this.printer = printer;
        this.labels = labels;
        scanner = new Scanner(System.in);
    }


    public Settings setupGame(){
        createBoardDimensions();
        createWinningSequenceLength();
        createPlayers();
        setupStartingPlayer();
        return new Settings(boardDimensions, player1, player2, startingPlayer, winningSequenceLength);
    }

    private void setupStartingPlayer() {
        printer.print(labels.getString("starts"));
        StartPlayerSetup setup = new StartPlayerSetup(scanner, labels);
        StartPlayerValidator validator = new StartPlayerValidator();
        String validUserInput = setup.action(printer::print, validator::validate);
        switch (validUserInput){
            case "X":
                startingPlayer = player1;
                break;
            case "O":
                startingPlayer = player2;
                break;
        }
    }

    private void createWinningSequenceLength() {
        printer.print(labels.getString("provideWinningSequenceLength"));
        WinningSequenceCreator creator = new WinningSequenceCreator(scanner, labels);
        int smallerBoardDimension = Math.min(boardDimensions.getWidth(), boardDimensions.getHeight());
        WinningSequenceValidator validator = new WinningSequenceValidator(smallerBoardDimension);
        String validUserInput = creator.action(printer::print, validator::validate);
        int length = Integer.valueOf(validUserInput);
        winningSequenceLength = new WinningSequenceLength(length);
    }

    private void createBoardDimensions() {
        printer.print(labels.getString("provideBoardSize"));
        printer.print(labels.getString("provideWidth"));
        int width = askUserForBoardDimension();
        printer.print(labels.getString("provideHeight"));
        int height = askUserForBoardDimension();
        this.boardDimensions = new BoardDimensions(new Width(width), new Height(height));
    }

    private int askUserForBoardDimension() {
        BoardDimensionCreator creator = new BoardDimensionCreator(scanner, labels);
        DimensionValidator validator = new DimensionValidator();
        String validUserInput = creator.action(printer::print, validator::validate);
        int dim = Integer.valueOf(validUserInput);
        return dim;
    }

    private void createPlayers() {
        player1 = createPlayer(Sign.X);
        player2 = createPlayer(Sign.O);
    }

    private Player createPlayer(Sign sign) {
        printer.print(labels.getString("provideUserName") + sign.toString());
        PlayerCreator playerCreator = new PlayerCreator(scanner, labels);
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        String name = playerCreator.action(printer::print, playerNameValidator::validate);
        return new Player(name, sign);
    }

}
