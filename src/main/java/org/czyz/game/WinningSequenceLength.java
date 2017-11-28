package org.czyz.game;

public class WinningSequenceLength {
    private final int length;

    public WinningSequenceLength(int length) {
        this.length = length;
    }

    public int value(){
        return length;
    }


    @Override
    public String toString() {
        return String.valueOf(length);
    }

}
