package org.czyz.initgame;

import org.czyz.ConsolePrinter;
import org.czyz.game.Settings;
import org.czyz.game.round.Triplet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.ResourceBundle;

import static org.testng.Assert.*;

@Test
public class GameInitializerTest {

    @DataProvider
    public Object[][] validValues() {
        return new Object[][]{
                {new Triplet(3, 3, 3), "pl1", "pl2", "X"},
                {new Triplet(100, 30, 29), "plaaaaaaaaaaaaaaaaaa1", "pl2", "x"},
                {new Triplet(32, 90, 30), "pl12222", "pl2dDawsEddd", "O"},
                {new Triplet(99, 4, 4), "player1", "player2", "o"},
        };
    }


    @Test(dataProvider = "validValues")
    public void shouldInitializeGameWithValidValues(Triplet triplet, String player1Name, String player2Name, String whoStarts){
        //given
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(triplet.width() + "\n");
        stringBuilder.append(triplet.height() + "\n");
        stringBuilder.append(triplet.length() + "\n");
        stringBuilder.append(player1Name + "\n");
        stringBuilder.append(player2Name + "\n");
        stringBuilder.append(whoStarts + "\n");

        setUpSystemIn(stringBuilder.toString());

        GameInitializer gameInitializer = new GameInitializer(new ConsolePrinter(), ResourceBundle.getBundle("lang"));

        //when
        Settings settings = gameInitializer.setupGame();

        //then
        assertEquals(settings.getBoardDimensions().getWidth(),triplet.width());
        assertEquals(settings.getBoardDimensions().getHeight(),triplet.height());
        assertEquals(settings.getWinningSequenceLength().value(),triplet.length());
        assertEquals(settings.getPlayer1().toString(), player1Name);
        assertEquals(settings.getPlayer2().toString(), player2Name);
        assertEquals(settings.getStartingPlayer().getSing().name(), whoStarts.toUpperCase());

    }

    private void setUpSystemIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}