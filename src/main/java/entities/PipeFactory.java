package entities;

import java.util.Random;

public class PipeFactory {

    private static Random random = new Random();

    enum PipeType {
        SNAKE,
        LADDER
    }

    public static Pipe createPipe(PipeType pipeType, Board board) {
        if (pipeType == PipeType.SNAKE) {
            while (true) {
                try {
                    int startingPoint = random.nextInt(board.getBoardSize() * board.getBoardSize());
                    int endingPoint = random.nextInt(startingPoint);
                    if (board.getPipes().containsKey(startingPoint) || board.getPipes().containsKey(endingPoint)) {
                        throw new IllegalArgumentException("pipe generation failed");
                    }
                    return new Snake(startingPoint, endingPoint);
                } catch (Throwable e) {
                    continue;
                }
            }
        } else if (pipeType == PipeType.LADDER) {
            while (true) {
                try {
                    int startingPoint = random.nextInt(board.getBoardSize() * board.getBoardSize());
                    int endingPoint = startingPoint + random.nextInt((board.getBoardSize() * board.getBoardSize()) - startingPoint);
                    if (board.getPipes().containsKey(startingPoint) || board.getPipes().containsKey(endingPoint)) {
                        throw new IllegalArgumentException("pipe generation failed");
                    }
                    return new Ladder(startingPoint, endingPoint);
                } catch (Throwable e) {
                    continue;
                }
            }
        } else {
            throw new IllegalArgumentException("unknown pipe type sent");
        }
    }

}
