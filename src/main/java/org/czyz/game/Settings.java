package org.czyz.game;

import org.czyz.Sign;

import java.util.Set;

public class Settings {
    private BoardDimensions boardDimensions;
    private final WinningSequenceLength winningSequenceLength;

    private Player player1;
    private Player player2;

    public Settings(){
        boardDimensions = new BoardDimensions(new Width(3),new Height( 3));
        winningSequenceLength = new WinningSequenceLength(3);
    }

    public Settings(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
        //TODO: UI
        winningSequenceLength = new WinningSequenceLength(3);
        player1 = new Player("P1", Sign.O);
        player2 = new Player("P2", Sign.X);
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

    public WinningSequenceLength getWinningSequenceLength() {
        return winningSequenceLength;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setDimensions(Width width, Height height) {
        boardDimensions= new BoardDimensions(width, height);
    }
}
