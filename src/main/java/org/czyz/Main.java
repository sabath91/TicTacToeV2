package org.czyz;

import org.czyz.game.*;
import org.czyz.game.round.Round;

class Main {

    public static void main(String[] args) {

        GameInitializer gameInitializer = new GameInitializer();
        Settings settings = gameInitializer.setupGame();

//        BoardDimensions bd = new BoardDimensions(new Width(3), new Height(3));

//        Settings settings = new Settings(bd);
        new Game(settings).play();
    }
}
