package org.czyz.game.round;

import org.czyz.Sign;

import java.util.stream.IntStream;

class MoveFeeder {
    private MovesHistory movesHistory;

    public MoveFeeder(MovesHistory movesHistory) {
        this.movesHistory = movesHistory;
    }

    public MoveFeeder fillLeftBottomCorner(Triplet triplet) {
        IntStream.iterate(triplet.height() * triplet.width() - triplet.width(), i -> i - triplet.width() + 1)
                .limit(triplet.length())
                .limit(triplet.length())
                .forEach(index -> {System.out.println("Teraz działa na indezie: "+ index); movesHistory.markField(new Position(index + 1), Sign.X);});

        return this;
    }

}
