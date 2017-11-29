package org.czyz.game.round;

import org.czyz.Sign;
import org.czyz.game.BoardDimensions;
import org.czyz.game.Height;
import org.czyz.game.Player;
import org.czyz.game.Score;
import org.czyz.game.Settings;
import org.czyz.game.Width;
import org.czyz.game.WinningSequenceLength;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;


@Test
public class RoundTest {

    @DataProvider(name = "moveSeqences")
    public Object[][] dp() {
        return new Object[][]{
                {1,2,3,4,5,6,7,8},
        };
    }

    @Test(dataProvider = "moveSeqences")
    public void shouldPlay(int[] movesSequence) {
        setUpSystemIn(movesSequence);
        //given
        Player player1 = new Player("player1", Sign.X);
        Player player2 = new Player("player2", Sign.O);
        Settings settings = new Settings(
                new BoardDimensions(new Width(3), new Height(3)),
                player1, player2, player1, new WinningSequenceLength(3));

        Round round = new Round(settings);



        //when
        Score score = round.play();

        //then
        assertNotNull(score);
    }

    private void setUpSystemIn(int[] movesSequence) {
        StringBuilder stfb = new StringBuilder();
        for (int i = 0; i < movesSequence.length; i++) {
            stfb.append(movesSequence[i]+"\n");
        }

        String s = stfb.toString();
        System.out.println(s);
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
    }

}