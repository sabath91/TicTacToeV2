package org.czyz.game.round;

import org.czyz.game.BoardBuilder;

class Round {

    private final BoardPrinter boardPrinter;
    private final MoveManager moveManager;

    public Round(BoardPrinter boardPrinter, MoveManager moveManager) {
        this.boardPrinter = boardPrinter;
        this.moveManager = moveManager;
    }

}
