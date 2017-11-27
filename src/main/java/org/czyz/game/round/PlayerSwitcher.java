package org.czyz.game.round;

import org.czyz.game.Player;

class PlayerSwitcher {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public PlayerSwitcher(Player player1, Player player2, Player starting) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = starting;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayers(){
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public Player lastPlayer() {
        if (currentPlayer.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }
}
