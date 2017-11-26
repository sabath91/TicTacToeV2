package org.czyz.game.round;

import java.util.Observable;
import java.util.Observer;

class RoundReferee implements Observer {
    MovesHistory movesHistory;
    public boolean canBeContinued() {
        return false;
    }

    public String getWinner() {
        return null;
    }

    @Override
    public void update(Observable movesHistory, Object arg) {
        this.movesHistory = (MovesHistory)movesHistory;
        checkSequences();
    }
}
