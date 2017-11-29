package org.czyz.initgame;

import org.czyz.*;
import org.czyz.game.*;

public class GameInitializer {
    private BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;
    private Player startingPlayer;
    private WinningSequenceLength winningSequenceLength;
    private Printer printer;

    public GameInitializer(Printer printer) {
        this.printer = printer;
    }

    public Settings setupGame(){
        createBoardDimensions();
        createWinningSequenceLength();
        createPlayers();
        setupStartingPlayer();
        return new Settings(boardDimensions, player1, player2, startingPlayer, winningSequenceLength);
    }

    private void setupStartingPlayer() {
        printer.print("Kto zaczyna O czy X?");
        StartPlayerSetup setup = new StartPlayerSetup();
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
        printer.print("Proszę podać rozmiar zwycięstwa");
        WinningSequenceCreator creator = new WinningSequenceCreator();
        int smallerBoardDimension = Math.min(boardDimensions.getWidth(), boardDimensions.getHeight());
        WinningSequenceValidator validator = new WinningSequenceValidator(smallerBoardDimension);
        String validUserInput = creator.action(printer::print, validator::validate);
        int length = Integer.valueOf(validUserInput);
        winningSequenceLength = new WinningSequenceLength(length);
    }

    private void createBoardDimensions() {
        printer.print("Proszę podać wymiary planszy");
        printer.print("Proszę podać szerokość");
        int width = askUserForBoardDimension();
        printer.print("Proszę podać wysokość");
        int height = askUserForBoardDimension();
        this.boardDimensions = new BoardDimensions(new Width(width), new Height(height));
    }

    private int askUserForBoardDimension() {
        BoardDimensionCreator creator = new BoardDimensionCreator();
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
        printer.print("Podaj imię gracza grającego " + sign.toString());
        PlayerCreator playerCreator = new PlayerCreator();
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        String name = playerCreator.action(printer::print, playerNameValidator::validate);
        return new Player(name, sign);
    }

}