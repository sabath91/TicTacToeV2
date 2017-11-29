package org.czyz.game.round;

import org.czyz.Printer;
import org.czyz.game.BoardBuilder;
import org.czyz.game.Score;
import org.czyz.game.Settings;

import java.util.ResourceBundle;

public class Round {

    private final BoardPrinter boardPrinter;
    private final MoveManager moveManager;
    private final MovesHistory movesHistory;
    private final PlayerSwitcher playerSwitcher;
    private RoundReferee roundReferee;
    private Score score;
    private final Printer printer;
    private final ResourceBundle labels;

    public Round(Settings settings, Printer printer, ResourceBundle labels) {
        BoardBuilder boardBuilder = new BoardBuilder(settings.getBoardDimensions());
        this.boardPrinter = new BoardPrinter(boardBuilder, settings.getBoardDimensions(), printer);
        this.movesHistory = new MovesHistory();
        this.playerSwitcher = new PlayerSwitcher(settings.getPlayer1(), settings.getPlayer2(), settings.getStartingPlayer());
        this.moveManager = new MoveManager(settings,printer, playerSwitcher, movesHistory, labels);
        this.roundReferee = new RoundReferee(settings);
        this.movesHistory.addObserver(boardBuilder);
        this.movesHistory.addObserver(roundReferee);
        this.printer = printer;
        this.labels = labels;
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
            printer.print(labels.getString("roundDraw"));
        }else {
            printer.print(labels.getString("roundWon")+playerSwitcher.lastPlayer());
        }
    }

}
