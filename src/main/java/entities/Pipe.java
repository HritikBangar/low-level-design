package entities;

public abstract class Pipe {
    int startingPosition;
    int endingPosition;

    public Pipe(int startingPosition, int endingPosition) {
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
        if (startingPosition == endingPosition) {
            throw new IllegalArgumentException("Starting position and ending position must be different");
        }
    }
}
