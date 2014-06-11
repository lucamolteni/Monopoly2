package it.monopoli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
    Player player1;
    Player player2;
    Board board;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        board = new Board();
    }

    @Test
    public void twoPlayersShouldBeAbleToMove() {

        Board board = new Board();
        board.move(player1, 4);
        board.move(player2, 5);
        board.move(player2, 3);

        Assert.assertEquals("4", board.position(player1));
        Assert.assertEquals("8", board.position(player2));
    }

    @Test
    public void on40ItShouldStartAgain() {
        board.move(player1, 39);
        board.move(player1, 4);

        Assert.assertEquals("3", board.position(player1));
    }

    @Test
    public void on0ItShouldStartAgain() {
        board.move(player1, 39);
        board.move(player1, 1);

        Assert.assertEquals("Go!", board.position(player1));
    }


}
