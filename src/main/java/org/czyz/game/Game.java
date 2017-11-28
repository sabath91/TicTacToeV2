package org.czyz.game;

import org.czyz.game.round.Round;

public class Game {
    private Score gameScore;
    private final Settings settings;


    public Game(Settings settings) {
        this.settings = settings;
        gameScore = new Score();
    }

    public void play() {
        for (int i = 0; i < 3; i++) {
            Round round = new Round(settings);
            Score score = round.play();
            gameScore.player1Score += score.player1Score;
            gameScore.player2Score += score.player2Score;
        }
        printScore();
    }

    private void printScore() {
        if (gameScore.isDraw()) {
            System.out.println("Remis");
        } else {
            if (gameScore.player1Score > gameScore.player2Score) {
                System.out.println("Meczy wygrał(a): " + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
                System.out.println("Przegrał:   " + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
            } else {
                System.out.println("Meczy wygrał(a): " + settings.getPlayer2().toString() + ":" + gameScore.player2Score);
                System.out.println("Przegrał: " + settings.getPlayer1().toString() + ":" + gameScore.player1Score);
            }
        }
    }
}
