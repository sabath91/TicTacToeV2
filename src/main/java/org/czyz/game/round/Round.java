package org.czyz.game.round;

import org.czyz.game.BoardBuilder;
import org.czyz.game.Score;
import org.czyz.game.Settings;

public class Round {

    private final BoardPrinter boardPrinter;
    private final MoveManager moveManager;
    private final MovesHistory movesHistory;
    private final PlayerSwitcher playerSwitcher;
    private RoundReferee roundReferee;
    private Score score;

    public Round(Settings settings) {
        BoardBuilder boardBuilder = new BoardBuilder(settings.getBoardDimensions());
        this.boardPrinter = new BoardPrinter(boardBuilder, settings.getBoardDimensions());
        this.movesHistory = new MovesHistory();
        this.playerSwitcher = new PlayerSwitcher(settings.getPlayer1(), settings.getPlayer2(), settings.startingPlayer());
        this.moveManager = new MoveManager(settings, playerSwitcher, movesHistory);
        this.roundReferee = new RoundReferee(settings);
        this.movesHistory.addObserver(boardBuilder);
        this.movesHistory.addObserver(roundReferee);
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
            System.out.println("Runda zakończona remis");
        }else {
            System.out.println("Rundę wygrał(a): " +playerSwitcher.lastPlayer());
        }
    }

}
