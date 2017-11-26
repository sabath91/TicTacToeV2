package org.czyz.game.round;

import org.czyz.game.BoardBuilder;
import org.czyz.game.Settings;

class Round {

    private final BoardPrinter boardPrinter;
    private final MoveManager moveManager;
    private final Settings settings;
    private final MovesHistory movesHistory;
    private final PlayerSwitcher playerSwitcher;
    private RoundReferee roundReferee;

    public Round(Settings settings) {
        this.settings = settings;
        BoardBuilder boardBuilder = new BoardBuilder(settings.getBoardDimensions());
        this.boardPrinter = new BoardPrinter(boardBuilder, settings.getBoardDimensions());
        movesHistory = new MovesHistory();
        playerSwitcher = new PlayerSwitcher(settings.getPlayer1(), settings.getPlayer2(), settings.getStartingPlayer());
        this.moveManager = new MoveManager(settings, playerSwitcher, movesHistory);

        roundReferee = new RoundReferee();
        movesHistory.addObserver(boardBuilder);
        movesHistory.addObserver(roundReferee);
    }

    public void play() {
        while (roundReferee.canBeContinued()) {
            moveManager.handleMove();
            playerSwitcher.switchPlayers();
        }
        System.out.println("Wygrał: " + roundReferee.getWinner());
    }

}
