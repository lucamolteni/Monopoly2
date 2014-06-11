package it.monopoli;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void realDiceShouldReturnRandomValuesBetween2and12() {
        Dice dice = new RealDice();

        for(int i = 0; i < 100; i++) {
            int res = dice.roll();
            Assert.assertTrue(res >= 2 && res <= 12);
        }
    }
}
