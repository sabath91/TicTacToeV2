package org.czyz.game;

import org.czyz.Printer;
import org.czyz.game.round.Round;

public class Game {
    private Score gameScore;
    private final Settings settings;
    private final Printer printer;

    public Game(Settings settings, Printer printer) {
        this.settings = settings;
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
            printer.print("Remis");
        } else {
            if (gameScore.player1Score > gameScore.player2Score) {
                printer.print("Meczy wygrał(a): " + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
                printer.print("Przegrał:   " + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
            } else {
                printer.print("Meczy wygrał(a): " + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
                printer.print("Przegrał: " + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
            }
        }
    }
}
