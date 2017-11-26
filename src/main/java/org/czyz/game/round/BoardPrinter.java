package org.czyz.game.round;

import org.czyz.game.*;

import java.util.List;

class BoardPrinter {

    private final BoardBuilder boardBuilder;

    public BoardPrinter(BoardBuilder boardBuilder) {
        this.boardBuilder = boardBuilder;
    }

    public void print() {

        Board b = boardBuilder
                .viaArrayList()
                .fillUpBoard()
                .fillWithMoves()
                .build();

        System.out.println(b);
    }
}
