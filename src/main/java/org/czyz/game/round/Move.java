package org.czyz.game.round;

import org.czyz.Sign;

class Move {
    final Position position;
    final Sign sign;

    Move(Position position, Sign sign) {
        this.position = position;
        this.sign = sign;
    }
}
