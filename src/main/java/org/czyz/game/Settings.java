package org.czyz.game;

import org.czyz.Sign;

import java.util.Set;

public class Settings {
    private final BoardDimensions boardDimensions;
    private final WinningSequenceLength winningSequenceLength;
    private final Player player1;
    private final Player player2;

    public Settings(BoardDimensions boardDimensions, Player player1, Player player2, WinningSequenceLength winningSequenceLength) {
        this.boardDimensions = boardDimensions;
        this.winningSequenceLength = winningSequenceLength;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player startingPlayer() {
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

}
