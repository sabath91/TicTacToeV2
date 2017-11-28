package org.czyz;

import org.czyz.game.Height;
import org.czyz.game.Player;
import org.czyz.game.Settings;
import org.czyz.game.Width;

class DataInitializer {
    private static final int MIN_BOARD_DIMENSION = 3;
    private static final int MAX_BOARD_DIMENSION = 101;
    private Settings settings;

    public DataInitializer() {
        this.settings = new Settings();
    }

    public void setupGame(){
        createBoardDimensions();
        createPlayers();
    }

    private void createBoardDimensions() {
        System.out.println("Proszę podać wymiary planszy");
        int width = askUserForBoardDimension("width: ");

        int height = askUserForBoardDimension("height: ");
        settings.setDimensions(new Width(width), new Height(height));
    }

    private int askUserForBoardDimension(String s) {

    }

    private void createPlayers() {
        settings.setPlayer1(createPlayer(Sign.X));
        settings.setPlayer2(createPlayer(Sign.O));
    }

    private Player createPlayer(Sign sign) {
        System.out.println("Podaj imię gracza grającego " + sign.toString());
        PlayerCreator playerCreator = new PlayerCreator();
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        String name = playerCreator.action(System.out::println, System.err::println, playerNameValidator::validate);
        return new Player(name, sign);
    }

}
