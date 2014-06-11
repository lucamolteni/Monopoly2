package it.monopoli;

import java.util.Random;

public class RealDice implements Dice {
    @Override
    public int roll() {
        double start = 2;
        double end = 12;
        double random = new Random().nextDouble();
        return Integer.valueOf((int) (start + (random * (end - start))));
    }
}
