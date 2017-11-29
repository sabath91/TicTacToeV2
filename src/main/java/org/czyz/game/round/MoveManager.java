package org.czyz.game.round;

import org.czyz.Printer;
import org.czyz.Sign;
import org.czyz.game.Settings;

import java.util.ResourceBundle;

class MoveManager {
    private final MoveHandler moveHandler;
    private final MoveValidator moveValidator;
    private final Settings settings;
    private final PlayerSwitcher playerSwitcher;
    private final MovesHistory movesHistory;
    private final Printer printer;
    private final ResourceBundle labels;

    MoveManager(Settings settings, Printer printer, PlayerSwitcher playerSwitcher, MovesHistory movesHistory, ResourceBundle labels) {
        this.settings = settings;
        this.printer = printer;
        this.movesHistory = movesHistory;
        this.playerSwitcher = playerSwitcher;
        this.moveHandler =new MoveHandler(labels);
        this.moveValidator = new MoveValidator(settings.getBoardDimensions(), movesHistory);
        this.labels=  labels;
    }

    void handleMove(){
        printer.print(playerSwitcher.getCurrentPlayer() + labels.getString("move"));
        String validUserInput = moveHandler.action(printer::print, moveValidator::validate);
        int move = Integer.parseInt(validUserInput);
        Position position = new Position(move);
        Sign playerSign = playerSwitcher.getCurrentPlayer().getSing();
        movesHistory.markField(position, playerSign);
    }

}
