package org.czyz.game.round;

import org.czyz.game.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class RoundRefereeTest {

//    @DataProvider(name = "winningSet")
//    public Object[][] invalidSequenceLength() {
//        return new Object[][]{
//                {"In row", new MoveFeeder()
//                },
//
//        };
//    }
//

//    @Test(dataProvider = "winningSet")
    public void shouldWinConceptualCheck() {
        //given

        Triplet triplet = new Triplet(4, 5, 4);
        RoundReferee roundReferee = new RoundRefereeBuilder(triplet).build();

        MovesHistory movesHistory = new MovesHistory();
        movesHistory.addObserver(roundReferee);

        //when
        new MoveFeeder(movesHistory)
                .fillLeftBottomCorner(triplet);

        //then
        assertTrue(!roundReferee.canBeContinued(), "Game cannot be continued - sb won or board is full");
        assertTrue(!roundReferee.score().isDraw(), "sb won");
    }

}