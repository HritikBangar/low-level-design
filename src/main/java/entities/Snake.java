package entities;

public class Snake extends Pipe{
    public Snake(int startingPosition, int endingPosition) {
        super(startingPosition, endingPosition);
        if(startingPosition<endingPosition){
            throw new IllegalArgumentException("Starting position should be greater for snakes");
        }
    }
}
