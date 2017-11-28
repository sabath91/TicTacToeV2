package org.czyz.game;

import org.czyz.Sign;

public class Player {
    private final String name;
    private final Sign sing;

    public Player(String name, Sign sing) {
        this.name = name;
        this.sing = sing;
    }

    public Sign getSing() {
        return sing;
    }

    @Override
    public String toString() {
        return name;
    }
}
