package org.czyz;

import org.czyz.game.board.*;

class Main {

    public static void main(String[] args) {



        BoardDimensions bd = new BoardDimensions(new Width(3), new Height(3));

        Board b = new BoardBuilder(bd)
                .viaArrayList()
                .fillUpBoard()
                .build();

        System.out.println(b);
    }
}
