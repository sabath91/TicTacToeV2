package org.czyz.game.round;

import org.czyz.game.Board;
import org.czyz.game.BoardBuilder;
import org.czyz.game.BoardDimensions;
import java.util.Formatter;

class BoardPrinter {

    private final BoardBuilder boardBuilder;
    private final int boardWidth;
    private final int boardSize;

    public BoardPrinter(BoardBuilder boardBuilder, BoardDimensions dimensions) {
        this.boardBuilder = boardBuilder;
        this.boardSize = dimensions.boardSize();
        this.boardWidth = dimensions.getWidth();
    }

    public void print() {

        Board gameBoard = boardBuilder
                .viaArrayList()
                .fillUpBoard()
                .fillWithMoves()
                .build();

        Formatter board = new Formatter();
        for (int i = 0; i < boardSize; i++) {
            if ((i + 1) % boardWidth == 0) {
                board.format("%5s", gameBoard.get(i));
            } else {
                board.format("%5s   |", gameBoard.get(i));
            }
            if ((i + 1) % boardWidth == 0) {
                board.format("\n");
                for (int j = 0; j < boardWidth - 1; j++) {
                    board.format("%8s|", "--------");
                }
                board.format("%8s", "--------");
                board.format("\n");
            }
        }

        System.out.println(board);
    }
}
