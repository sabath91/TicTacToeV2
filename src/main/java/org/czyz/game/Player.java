package org.czyz.game;

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
}
