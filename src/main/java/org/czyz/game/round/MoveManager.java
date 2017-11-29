package org.czyz.game.round;

import org.czyz.game.Settings;
import org.czyz.Sign;

class MoveManager {
    private final MoveHandler moveHandler;
    private final MoveValidator moveValidator;
    private final Settings settings;
    private final PlayerSwitcher playerSwitcher;
    private final MovesHistory movesHistory;

    MoveManager(Settings settings, PlayerSwitcher playerSwitcher, MovesHistory movesHistory) {
        this.settings = settings;
        this.movesHistory = movesHistory;
        this.playerSwitcher = playerSwitcher;
        this.moveHandler =new MoveHandler();
        this.moveValidator = new MoveValidator(settings.getBoardDimensions(), movesHistory);
    }

    void handleMove(){
        System.out.println(playerSwitcher.getCurrentPlayer() + " - gdzie chcesz postawić znak?");
        String validUserInput = moveHandler.action(System.err::println, moveValidator::validate);
        int move = Integer.parseInt(validUserInput);
        Position position = new Position(move);
        Sign playerSign = playerSwitcher.getCurrentPlayer().getSing();
        movesHistory.markField(position, playerSign);
    }

}
