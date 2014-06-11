package it.monopoli;

public class GameEvent {
    private int diceRoll;
    private String movement;
    private Player player;


    public GameEvent(int diceRoll, String movement, Player player) {
        this.diceRoll = diceRoll;
        this.movement = movement;
        this.player = player;
    }

    public String getDiceRoll() {
        return String.format("%s has rolled %s", player.getPlayerName(),  diceRoll);
    }

    public String getMovement() {
        return String.format("%s has moved to %s", player.getPlayerName(),movement);
    }
}
