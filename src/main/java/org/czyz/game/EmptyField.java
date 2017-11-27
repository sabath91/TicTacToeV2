package org.czyz.game;

public class EmptyField implements Field {
    private final int index;

    public EmptyField(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
