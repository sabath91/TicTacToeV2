package org.czyz;

import org.czyz.game.*;
import org.czyz.initgame.GameInitializer;

class Main {

    public static void main(String[] args) {

        GameInitializer gameInitializer = new GameInitializer();
        Settings settings = gameInitializer.setupGame();
        new Game(settings).play();

    }
}
