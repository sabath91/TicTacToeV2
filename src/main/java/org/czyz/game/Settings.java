package org.czyz.game;

public class Settings {
    private final BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;

    public Settings(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
        player1 = new Player("Ala", Sign.O);
        player2 = new Player("Piotrek", Sign.X);
    }

    public Player getStartingPlayer() {
        return player1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }


    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }
}
