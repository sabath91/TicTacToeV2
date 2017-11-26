package org.czyz.game;

public class Settings {
    private final BoardDimensions boardDimensions;
    private Player player1;
    private Player player2;

    public Settings(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
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
