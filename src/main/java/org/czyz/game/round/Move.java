package org.czyz.game.round;

import org.czyz.game.Sign;

class Move {
    Position position;
    Sign sign;

    public Move(Position position, Sign sign) {
        this.position = position;
        this.sign = sign;
    }
}