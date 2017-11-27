package org.czyz.game.round;

import org.czyz.game.Sign;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class MovesHistory extends Observable {

    private Set<Position> xMoves;
    private Set<Position> oMoves;
    private Move lastMove;

    public MovesHistory() {
        xMoves = new HashSet<>();
        oMoves = new HashSet<>();
    }

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
        lastMove = new Move(position, playerSign);
        setChanged();
        notifyObservers();
    }


    public Move getLastMove() {
        return lastMove;
    }

    public Set<Position> getXMoves() {
        return xMoves;
    }

    public Set<Position> getOMoves() {
        return oMoves;
    }

    public int size(){
        return xMoves.size() + oMoves.size();
    }
}
