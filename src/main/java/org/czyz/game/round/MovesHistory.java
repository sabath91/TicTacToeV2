package org.czyz.game.round;

import org.czyz.game.Sign;

import java.util.Observable;
import java.util.Set;

public class MovesHistory extends Observable {

    private Set<Position> xMoves;
    private Set<Position> oMoves;
    private Move lastMove;

    public boolean isPositionFree(Position position) {
        return !xMoves.contains(position) && !oMoves.contains(position);
    }


    void markField(Position position, Sign playerSign) {

        switch (playerSign) {
            case O:
                oMoves.add(position);
                break;
            case X:
                xMoves.add(position);
                break;
        }
        lastMove = new Move(position,playerSign);

        notifyObservers();
    }


    public Move getLastMove() {
        return lastMove;
    }
}
