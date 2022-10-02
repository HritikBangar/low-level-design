package services;

import java.util.Random;

public class FairRooling implements RoolingStrategy {

    private Random random = new Random();

    @Override
    public int rool(int numOfDice) {
        return (1 + random.nextInt(6));
    }
}
