package org.czyz.game;

import org.czyz.game.round.MovesHistory;
import org.czyz.game.round.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardBuilder implements Observer {
    private final BoardDimensions dimensions;
    private List<Field> fields;
    private MovesHistory moves;

    public BoardBuilder(BoardDimensions dimensions) {
        this.dimensions = dimensions;
        moves = new MovesHistory();
    }

    public BoardBuilder viaArrayList(){
        fields = new ArrayList<>(dimensions.boardSize());
        return this;
    }

    public Board build(){
        return new Board(fields);
    }

    public BoardBuilder fillUpBoard(){
        //+1 to show number but index --->  0 is too similar to O
        fields = IntStream.range(1, dimensions.boardSize()+1).mapToObj(number -> new EmptyField(number)).collect(Collectors.toList());
        return this;
    }


    public BoardBuilder fillWithMoves() {
        for (Position position: moves.getOMoves()) {
            fields.set(position.getIndex(), new OField());
        }
        for (Position position: moves.getXMoves()) {
            fields.set(position.getIndex(), new XField());
        }
        return this;
    }


    @Override
    public void update(Observable movesHistory, Object arg) {
        moves = (MovesHistory) movesHistory;
    }
}
