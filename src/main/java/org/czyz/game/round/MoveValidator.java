package org.czyz.game.round;

import org.czyz.game.BoardDimensions;

class MoveValidator{

    private final BoardDimensions dimensions;
    private final MovesHistory moves;

    public MoveValidator(BoardDimensions dimensions, MovesHistory movesHistory) {
        this.moves = movesHistory;
        this.dimensions = dimensions;
    }

    boolean validate(String userInput){
        int position;
        try {
            position = Integer.parseInt(userInput);
            if(position == 0){
                System.exit(0);
            }
        }catch (NumberFormatException e ){
            return false;
        }
        return isInRange(position) && moves.isPositionFree(new Position(position));
    }

    private boolean isInRange(int position) {
        return position > 0 && position <= dimensions.boardSize()+1;
    }

}
