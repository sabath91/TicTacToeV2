package org.czyz;

import org.czyz.game.BoardDimensions;

class WinningSequenceValidator {
    private static final int MIN_BOARD_DIMENSION = 3;
    private static int smallerBoardDimension;

    public WinningSequenceValidator(int smallerBoardDimension) {
        this.smallerBoardDimension =smallerBoardDimension;
    }

    boolean validate(String userInput){
        int length = Integer.valueOf(userInput);
        return length>=MIN_BOARD_DIMENSION && length<=smallerBoardDimension;
    }

}
