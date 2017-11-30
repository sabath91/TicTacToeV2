package org.czyz.game.round;

import org.czyz.game.round.Field;

class EmptyField implements Field {
    private final int index;

    EmptyField(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
