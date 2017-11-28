//package org.czyz;
//
//import org.czyz.game.Player;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.ByteArrayInputStream;
//
//import static org.testng.Assert.*;
//
//@Test
//public class GameInitializerTest {
//
//    @DataProvider(name = "boardDimensions")
//    public Object[][] createBoardDimensions() {
//        return new Object[][]{
//                {44, 44},
//                {3, 3},
//                {50, 3},
//                {4, 45}
//        };
//    }
//
//    @Test(dataProvider = "boardDimensions")
//    public void shouldBeAbleToCreateProperDimensions(int xSize, int ySize) {
//        //given
//        ByteArrayInputStream in = new ByteArrayInputStream((xSize + "\n" + ySize).getBytes());
//
//        //when
//        GameInitializer gameInitializer = new GameInitializer();
//        System.setIn(in);
//        gameInitializer.createBoardDimensions();
//
//        //then
//        assertEquals(gameInitializer.getBoardDimensions().getWidth(), xSize);
//        assertEquals(gameInitializer.getBoardDimensions().getWidth(), ySize);
//    }
//
//    public void shouldBeAbleToCreatePlayer(){
//        ByteArrayInputStream in = new ByteArrayInputStream(("Player1" + System.lineSeparator() + "Player2").getBytes());
//        System.setIn(in);
//
//        GameInitializer gameInitializer = new GameInitializer();
//        gameInitializer.createPlayers();
//
//        assertEquals(gameInitializer.getPlayer1(), new Player("Player1", Sign.X));
//        assertEquals(gameInitializer.getPlayer2(), new Player("Player2", Sign.X));
//    }
//
//}