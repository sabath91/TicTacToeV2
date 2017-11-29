package org.czyz.game;

import org.czyz.Printer;
import org.czyz.game.round.Round;

import java.util.ResourceBundle;

public class Game {
    private Score gameScore;
    private final Settings settings;
    private ResourceBundle labels;
    private final Printer printer;

    public Game(Settings settings, Printer printer, ResourceBundle labels) {
        this.settings = settings;
        this.labels = labels;
        gameScore = new Score();
        this.printer = printer;
        
    }

    public void play() {
        for (int i = 0; i < 3; i++) {
            Round round = new Round(settings, printer, labels);
            Score score = round.play();
            gameScore.player1Score += score.player1Score;
            gameScore.player2Score += score.player2Score;
        }
        printScore();
    }

    private void printScore() {
        if (gameScore.isDraw()) {
            printer.print(labels.getString("draw"));
        } else {
            if (gameScore.player1Score > gameScore.player2Score) {
                printer.print(labels.getString("gameWon") + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
                printer.print(labels.getString("gameLost") + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
            } else {
                printer.print(labels.getString("gameWon") + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
                printer.print(labels.getStringArray("gameLost") + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
            }
        }
    }
}
