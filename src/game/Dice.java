package game;

import java.util.Random;

public class Dice {

    private static final Random random = new Random();

    // TURN-01
    public static int roll(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("🎲");
        }
        return random.nextInt(n) + 1;
    }
}