package services;

public class DiceService {

    private static volatile DiceService diceService;

    private final int numOfDice = 1;
    private RoolingStrategy roolingStrategy;

    public static DiceService getInstance(RoolingStrategy roolingStrategy) {
        if(diceService==null){
            synchronized (DiceService.class){
                if (diceService == null)
                    diceService = new DiceService(roolingStrategy);
            }
        }
        return diceService;
    }

    public DiceService(RoolingStrategy roolingStrategy) {
        this.roolingStrategy = roolingStrategy;
    }

    public int rollDice() {
        return roolingStrategy.rool(numOfDice);
    }
}
