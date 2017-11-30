package org.czyz.game.round;

public class Position {

    private final int movePosition;

    public Position(int movePosition) {
        this.movePosition = movePosition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return movePosition == position.movePosition;
    }

    @Override
    public int hashCode() {
        return movePosition;
    }

    public int getIndex() {
        return movePosition - 1;
    }
}
