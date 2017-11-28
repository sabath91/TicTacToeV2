package org.czyz;

class DimensionValidator {
    private static final int MIN_BOARD_DIMENSION = 3;
    private static final int MAX_BOARD_DIMENSION = 101;


    boolean validate(String userInput){
        int dim = Integer.valueOf(userInput);
        return dim>=MIN_BOARD_DIMENSION && dim<=MAX_BOARD_DIMENSION;
    }
}
