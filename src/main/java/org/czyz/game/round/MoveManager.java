package org.czyz.game.round;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.czyz.game.Settings;
import org.czyz.game.Sign;

import java.util.Set;

class MoveManager {
    private final MoveHandler moveHandler;
    private final MoveValidator moveValidator;
    private final Settings settings;
    private final PlayerSwitcher playerSwitcher;
    private final MovesHistory movesHistory;

    public MoveManager(Settings settings, PlayerSwitcher playerSwitcher, MovesHistory movesHistory) {
        this.settings = settings;
        this.movesHistory = movesHistory;
        this.playerSwitcher = playerSwitcher;
        this.moveHandler =new MoveHandler();
        this.moveValidator = new MoveValidator(settings.getBoardDimensions(), movesHistory);
    }

    public void handleMove(){
        System.out.println(playerSwitcher.getCurrentPlayer() + " - gdzie chcesz postawić znak");
        String validUserInput = moveHandler.action(System.out::println, System.err::println, moveValidator::validate);
        int move = Integer.parseInt(validUserInput);
        Position position = new Position(move);
        Sign playerSign = playerSwitcher.getCurrentPlayer().getSing();
        movesHistory.markField(position, playerSign);
    }





}
