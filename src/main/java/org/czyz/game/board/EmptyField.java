package org.czyz.game.board;

class EmptyField implements Field {
    private final int index;

    public EmptyField(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
