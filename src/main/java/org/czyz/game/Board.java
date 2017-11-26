package org.czyz.game;

import java.util.List;

public class Board {

    private final List<Field> board;

    Board(List<Field> board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
