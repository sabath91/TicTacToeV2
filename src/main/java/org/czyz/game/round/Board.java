package org.czyz.game.round;

import org.czyz.game.round.Field;

import java.util.List;

class Board {

    private final List<Field> board;

    Board(List<Field> board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return board.toString();
    }

    Field get(int i) {
        return board.get(i);
    }
}
