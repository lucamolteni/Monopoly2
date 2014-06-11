package it.monopoli;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Map<Player, Integer> position = new HashMap<Player, Integer>();

    public String position(Player p) {
        final Integer pos = position.get(p);
        if(pos == 0) {
            return "Go!";
        }
        return String.valueOf(pos);
    }

    public void move(Player player, int amount) {
        if(!position.containsKey(player)) {
            position.put(player, 0);
        }

        int currentPosition = position.get(player);
        currentPosition = (currentPosition + amount) % 40;

        position.put(player, currentPosition);
    }
}
