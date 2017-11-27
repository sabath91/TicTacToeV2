package org.czyz.game.round;

import javafx.geometry.Pos;
import org.czyz.game.*;

import java.util.*;

class RoundReferee implements Observer {
    private final WinningSequenceLength winningSequenceLength;
    private final int boardWidth;
    private final int boardHeight;
    private final BoardDimensions boardDimensions;
    private MovesHistory movesHistory;
    private Move lastMove;
    Field wanted;
    private Board board;
    private boolean canBeContinued;


    public RoundReferee(Settings settings) {
        movesHistory = new MovesHistory();
        winningSequenceLength = settings.getWinningSequenceLength();
        boardDimensions = settings.getBoardDimensions();
        boardWidth = settings.getBoardDimensions().getWidth();
        boardHeight = settings.getBoardDimensions().getHeight();
        canBeContinued = true;

    }

    public boolean canBeContinued() {
        return canBeContinued;
    }

    @Override
    public void update(Observable movesHistory, Object arg) {
        this.movesHistory = (MovesHistory) movesHistory;
        this.lastMove = ((MovesHistory) movesHistory).getLastMove();

        board = new BoardBuilder(boardDimensions)
                .viaArrayList()
                .fillUpBoard()
                .fillWithMoves(this.movesHistory)
                .build();
        canBeContinued = !isWinningMove() && isBoardNotFull();
    }

    private boolean isBoardNotFull() {
        return movesHistory.size() < boardDimensions.boardSize();
    }

    public boolean isWinningMove() {
        Sign sign = lastMove.sign;
        switch (sign){
            case O:
                wanted = new OField();
                break;
            case X:
                wanted = new XField();
                break;

        }
        System.out.println("Is winnging: "+ (winOnRow() || winOnColumn() || winOnRightDiagonal() || winOnLeftDiagonal()));
        return winOnRow() || winOnColumn() || winOnRightDiagonal() || winOnLeftDiagonal();
    }

    private boolean winOnLeftDiagonal() {
        ArrayList<Field> list = getLeftDiagonal(lastMove.position.getIndex());
        return isWinningSequenceOnList(list);
    }


    private boolean winOnRightDiagonal() {
        ArrayList<Field> list = getRightDiagonal(lastMove.position.getIndex());
        return isWinningSequenceOnList(list);
    }

    private boolean winOnColumn() {
        ArrayList<Field> list = getColumn(lastMove.position.getIndex());
        return isWinningSequenceOnList(list);
    }

    boolean winOnRow() {
        ArrayList<Field> list = getRow(lastMove.position.getIndex());
        return isWinningSequenceOnList(list);
    }


    private boolean isWinningSequenceOnList(ArrayList<Field> list) {
        int maxLength = 0;
        for (Field field : list) {
            if (field.toString().equals(wanted.toString())) {
                maxLength++;
                if (maxLength >= winningSequenceLength.value()) return true;
            } else {
                maxLength = 0;
            }
        }
        return false;
    }

    public ArrayList<Field> getRow(int lastMove) {
        int rowNumber = lastMove / boardWidth;
        ArrayList<Field> result = new ArrayList<>(boardWidth);
        for (int i = 0; i < boardWidth; i++) {
            result.add(board.get(rowNumber * boardWidth + i));
        }
        return result;
    }

    public ArrayList<Field> getRightDiagonal(int lastMove) {
        int initRowNumber = lastMove / boardWidth;
        int initColumnNumber = lastMove  % boardWidth;
        int difference = Math.abs(Math.min(initColumnNumber, initRowNumber) - 0);
        int rowNumber = initRowNumber - difference;
        int columnNumber = initColumnNumber - difference;
        int resultSize = boardWidth;

        ArrayList<Field> result = new ArrayList<>();
        try {
            result.add(board.get(rowNumber * boardWidth + columnNumber));
        } catch (IndexOutOfBoundsException e) {
            result.add(new EmptyField(-1));
        }

        for (int i = 1; i < resultSize; i++) {
            try {
                result.add(board.get(rowNumber * boardWidth + columnNumber + i * (boardWidth + 1)));
            } catch (IndexOutOfBoundsException e) {
                result.add(new EmptyField(-1));
            }

        }
        return result;
    }

    public ArrayList<Field> getLeftDiagonal(int lastMove) {
        int initRowNumber = lastMove / boardWidth;
        int initColumnNumber = lastMove % boardWidth;
        int difference = Math.abs(Math.min(initColumnNumber, initRowNumber) - 0);
        int rowNumber = initRowNumber + difference;
        int columnNumber = initColumnNumber - difference;
        int resultSize = boardWidth;

        ArrayList<Field> result = new ArrayList<>();
        try {
            result.add(board.get(rowNumber * boardWidth + columnNumber * boardHeight));
        } catch (IndexOutOfBoundsException e) {
            result.add(new EmptyField(-1));
        }
        for (int i = 1; i < resultSize; i++) {
            try {
                result.add(board.get((rowNumber * boardWidth + columnNumber * boardHeight) - (i * (boardWidth - 1))));
            } catch (IndexOutOfBoundsException e) {
                result.add(new EmptyField(-1));
            }
        }
        return result;
    }

    public ArrayList<Field> getColumn(int lastMove) {
        int columnNumber = lastMove % boardWidth;
        ArrayList<Field> result = new ArrayList<>(boardHeight);
        for (int i = 0; i < boardHeight; i++) {
            int index = columnNumber + (boardWidth * i);
            result.add(board.get(index));
        }
        return result;

    }

    public Score score() {
        Score score = new Score();
        if(isBoardNotFull() && !canBeContinued){ // restoring value of isWinningMove without calculations
            if(lastMove.sign.equals(Sign.O)){
                score.player1Win();
            }else {
                score.player2Win();
            }
        }else{ // draw
            score.markDraw();
        }
        return score;
    }
}
