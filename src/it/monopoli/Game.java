package it.monopoli;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<Player>();

    private int currentTurn = 0;
    private int currentRound = 1;

    private Board board;


    public Game(Board board) {
        this.board = board;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void addPlayer(String p) {
        players.add(new Player(p));
    }

    public Player currentPlayer() {
        return players.get(currentTurn);
    }

    public GameEvent nextTurn(Dice dice) {
        if(currentRound == 20) {
            return new EndedGameEvent();
        }

        final int roll = dice.roll();
        final Player currentPlayer = currentPlayer();

        board.move(currentPlayer, roll);

        updateTurnAndRound();

        return new GameEvent(roll, board.position(currentPlayer), currentPlayer);
    }

    private void updateTurnAndRound() {
        final int newTurn = currentTurn + 1;
        if(newTurn >= players.size()) {
            currentRound++;
        }
        currentTurn = newTurn % players.size();
    }

    public int currentRound() {
        return currentRound;
    }
}
