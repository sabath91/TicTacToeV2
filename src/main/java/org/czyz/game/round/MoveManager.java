package org.czyz.game.round;

import org.czyz.Printer;
import org.czyz.game.Settings;
import org.czyz.Sign;

class MoveManager {
    private final MoveHandler moveHandler;
    private final MoveValidator moveValidator;
    private final Settings settings;
    private final PlayerSwitcher playerSwitcher;
    private final MovesHistory movesHistory;
    private final Printer printer;

    MoveManager(Settings settings, Printer printer, PlayerSwitcher playerSwitcher, MovesHistory movesHistory) {
        this.settings = settings;
        this.printer = printer;
        this.movesHistory = movesHistory;
        this.playerSwitcher = playerSwitcher;
        this.moveHandler =new MoveHandler();
        this.moveValidator = new MoveValidator(settings.getBoardDimensions(), movesHistory);
    }

    void handleMove(){
        printer.print(playerSwitcher.getCurrentPlayer() + " - gdzie chcesz postawić znak?");
        String validUserInput = moveHandler.action(printer::print, moveValidator::validate);
        int move = Integer.parseInt(validUserInput);
        Position position = new Position(move);
        Sign playerSign = playerSwitcher.getCurrentPlayer().getSing();
        movesHistory.markField(position, playerSign);
    }

}
