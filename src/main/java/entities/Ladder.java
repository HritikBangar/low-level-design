package entities;

public class Ladder extends Pipe {
    public Ladder(int startingPosition, int endingPosition) {
        super(startingPosition, endingPosition);
        if (endingPosition < startingPosition) {
            throw new IllegalArgumentException("ending position must be greater for ladder");
        }
    }
}
