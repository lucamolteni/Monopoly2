package it.monopoli;

public class EndedGameEvent extends GameEvent {
    public EndedGameEvent() {
        super(0, "", null);
    }

    @Override
    public String getDiceRoll() {
        return "Game has ended";
    }

    @Override
    public String getMovement() {
        return "";
    }
}
