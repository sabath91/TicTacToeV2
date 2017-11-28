package org.czyz;

import org.czyz.game.*;

class DataInitializer {
    private BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;
    private WinningSequenceLength winningSequenceLength;

    public DataInitializer() {}

    public Settings setupGame(){
        createBoardDimensions();
        createPlayers();
        createWinningSequenceLength();

        return new Settings(boardDimensions, player1, player2, winningSequenceLength);
    }

    private void createWinningSequenceLength() {
        System.out.println("Proszę podać rozmiar zwycięstwa");
        WinningSequenceCreator creator = new WinningSequenceCreator();
        int smallerBoardDimension = Math.min(boardDimensions.getWidth(), boardDimensions.getHeight());
        WinningSequenceValidator validator = new WinningSequenceValidator(smallerBoardDimension);
        String validUserInput = creator.action(System.out::println, System.err::println, validator::validate);
        int length = Integer.valueOf(validUserInput);
        winningSequenceLength = new WinningSequenceLength(length);
    }

    private void createBoardDimensions() {
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

    private void createPlayers() {
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
