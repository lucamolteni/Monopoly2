package it.monopoli;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player1;
    private Player player2;
    private Game game;
    private Dice diceFour;
    private Dice diceSeven;
    private Board board;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        board = new Board();
        game = new Game(board);

        game.addPlayer(player1);
        game.addPlayer(player2);

        diceFour = new FakeDice(4);
        diceSeven = new FakeDice(7);
    }

    @Test
    public void afterHavingPlayedThereShouldBeANewRound() {

        assertEquals(1, game.currentRound());

        game.nextTurn(diceFour);
        game.nextTurn(diceFour);

        assertEquals(2, game.currentRound());
    }

    @Test
    public void gameSimulation() {

        GameEvent event = game.nextTurn(diceFour);

        assertEquals("Player1 has rolled 4", event.getDiceRoll());
        assertEquals("Player1 has moved to 4", event.getMovement());

        GameEvent event2 = game.nextTurn(diceSeven);

        assertEquals("Player2 has rolled 7", event2.getDiceRoll());
        assertEquals("Player2 has moved to 7", event2.getMovement());

        GameEvent event3 = game.nextTurn(diceSeven);

        assertEquals("Player1 has rolled 7", event3.getDiceRoll());
        assertEquals("Player1 has moved to 11", event3.getMovement());

        GameEvent event4 = game.nextTurn(diceSeven);

        assertEquals("Player2 has rolled 7", event4.getDiceRoll());
        assertEquals("Player2 has moved to 14", event4.getMovement());

    }

    @Test
    public void after20RoundGameShouldEnd() {
        GameEvent event = null;
        for(int i = 0; i < 20 * 2; i++) {
            event = game.nextTurn(diceFour);
        }

        assertEquals("Game has ended", event.getDiceRoll());
        assertEquals("", event.getMovement());

    }

    private class FakeDice implements Dice {
        private int fakeNumber;

        private FakeDice(int fakeNumber) {
            this.fakeNumber = fakeNumber;
        }

        @Override
        public int roll() {
            return fakeNumber;
        }
    }
}
