package org.czyz.game.round;

import org.czyz.game.BoardBuilder;
import org.czyz.game.Score;
import org.czyz.game.Settings;

public class Round {

    private final BoardPrinter boardPrinter;
    private final MoveManager moveManager;
    private final Settings settings;
    private final MovesHistory movesHistory;
    private final PlayerSwitcher playerSwitcher;
    private RoundReferee roundReferee;
    private Score score;

    public Round(Settings settings) {
        this.settings = settings;
        BoardBuilder boardBuilder = new BoardBuilder(settings.getBoardDimensions());
        this.boardPrinter = new BoardPrinter(boardBuilder, settings.getBoardDimensions());
        movesHistory = new MovesHistory();
        playerSwitcher = new PlayerSwitcher(settings.getPlayer1(), settings.getPlayer2(), settings.startingPlayer());
        this.moveManager = new MoveManager(settings, playerSwitcher, movesHistory);

        roundReferee = new RoundReferee(settings);
        movesHistory.addObserver(boardBuilder);
        movesHistory.addObserver(roundReferee);
    }

    public Score play() {
        while (roundReferee.canBeContinued()) {
            boardPrinter.print();
            moveManager.handleMove();
            playerSwitcher.switchPlayers();
        }
        boardPrinter.print();
        score = roundReferee.score();
        printScore();
        return score;
    }

    private void printScore() {
        if(score.isDraw()){
            System.out.println("Remis");
        }else {
            System.out.println("Wygrał(a): " +playerSwitcher.lastPlayer());
        }
    }

}
