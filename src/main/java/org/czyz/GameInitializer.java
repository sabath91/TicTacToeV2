package org.czyz;

import org.czyz.game.*;

class GameInitializer {
    private BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;
    private Player startingPlayer;
    private WinningSequenceLength winningSequenceLength;

    //just for test - how to do unit tests for it?
    BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    Player getPlayer1() {
        return player1;
    }

    Player getPlayer2() {
        return player2;
    }

    WinningSequenceLength getWinningSequenceLength() {
        return winningSequenceLength;
    }

    public GameInitializer() {}

    public Settings setupGame(){
        createBoardDimensions();
        createWinningSequenceLength();
        createPlayers();
        setupStartingPlayer();

        return new Settings(boardDimensions, player1, player2, startingPlayer, winningSequenceLength);
    }

    private void setupStartingPlayer() {
        System.out.println("Kto zaczyna O czy X?");
        StartPlayerSetup setup = new StartPlayerSetup();
        StartPlayerValidator validator = new StartPlayerValidator();
        String validUserInput = setup.action(System.out::println, System.err::println, validator::validate);
        switch (validUserInput){
            case "X":
                startingPlayer = player1;
                break;
            case "O":
                startingPlayer = player2;
                break;
        }
    }

    void createWinningSequenceLength() {
        System.out.println("Proszę podać rozmiar zwycięstwa");
        WinningSequenceCreator creator = new WinningSequenceCreator();
        int smallerBoardDimension = Math.min(boardDimensions.getWidth(), boardDimensions.getHeight());
        WinningSequenceValidator validator = new WinningSequenceValidator(smallerBoardDimension);
        String validUserInput = creator.action(System.out::println, System.err::println, validator::validate);
        int length = Integer.valueOf(validUserInput);
        winningSequenceLength = new WinningSequenceLength(length);
    }

    void createBoardDimensions() {
        System.out.println("Proszę podać wymiary planszy");
        System.out.println("Proszę podać szerokość");
        int width = askUserForBoardDimension();
        System.out.println("Proszę podać wysokość");
        int height = askUserForBoardDimension();
        this.boardDimensions = new BoardDimensions(new Width(width), new Height(height));
    }

    private int askUserForBoardDimension() {
        BoardDimensionCreator creator = new BoardDimensionCreator();
        DimensionValidator validator = new DimensionValidator();
        String validUserInput = creator.action(System.out::println, System.err::println, validator::validate);
        int dim = Integer.valueOf(validUserInput);
        return dim;
    }

    void createPlayers() {
        player1 = createPlayer(Sign.X);
        player2 = createPlayer(Sign.O);
    }

    private Player createPlayer(Sign sign) {
        System.out.println("Podaj imię gracza grającego " + sign.toString());
        PlayerCreator playerCreator = new PlayerCreator();
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        String name = playerCreator.action(System.out::println, System.err::println, playerNameValidator::validate);
        return new Player(name, sign);
    }

}
