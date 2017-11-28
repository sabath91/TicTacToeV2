package org.czyz.game.round;

import org.czyz.Sign;
import org.czyz.game.*;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;
@Test
public class RoundRefereeTest {

    public void shouldWinOnRow(){
        //given
        BoardDimensions boardDimensions = new BoardDimensions(new Width(3), new Height(3));
        Player player1 = new Player("Player1", Sign.X);
        Player player2 = new Player("Player2", Sign.O);
        WinningSequenceLength length = new WinningSequenceLength(3);
        Settings settings = new Settings(boardDimensions, player1, player2, length);
        RoundReferee roundReferee = new RoundReferee(settings);
        PlayerSwitcher playerSwitcher = new PlayerSwitcher(player1, player2, player1);
        MovesHistory movesHistory = new MovesHistory();
        MoveManager moveManager = new MoveManager(settings,playerSwitcher, movesHistory);

        //when
        //I should do some moves. after last I should win.
        //How to simulate user input for each move?
        //if moveHistory is created for round i have to setUp round for this test.
        //If yes it is still unit test?
//        moveManager.handleMove(1);
//        moveManager.handleMove(2);
//        moveManager.handleMove(3);

        //then
        assertTrue(roundReferee.isWinningMove());

    }

}