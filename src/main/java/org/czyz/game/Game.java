package org.czyz.game;

import org.czyz.ui.Printer;
import org.czyz.game.round.Round;
import org.czyz.settings.Settings;

import java.util.ResourceBundle;

public class Game {
    private final Score gameScore;
    private final Settings settings;
    private final ResourceBundle labels;
    private final Printer printer;

    public Game(Settings settings, Printer printer) {
        this.settings = settings;
        this.labels = ResourceBundle.getBundle("lang");
        gameScore = new Score();
        this.printer = printer;
        
    }

    public void play() {
        for (int i = 0; i < 3; i++) {
            Round round = new Round(settings, printer);
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
                String winner = settings.getPlayer1().getSing().toString();
                String loser = settings.getPlayer2().getSing().toString();
                printer.print(labels.getString("gameWon") + winner + ". " + winner + ":" + gameScore.player1Score + " " + loser +":"+gameScore.player2Score);
            } else {
                String winner = settings.getPlayer1().getSing().toString();
                String loser = settings.getPlayer2().getSing().toString();
                printer.print(labels.getString("gameWon") + winner + ". " + winner + ":" + gameScore.player2Score + " " + loser +":"+gameScore.player1Score);
            }
        }
    }
}
