package entities;

import java.util.HashMap;

public class Board {
    private int boardSize;
    private HashMap<Integer, Pipe> pipes;

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public HashMap<Integer, Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(HashMap<Integer, Pipe> pipes) {
        this.pipes = pipes;
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.pipes = new HashMap<>();
        Boolean flag = false;
        for (int i = 0; i < boardSize; i++) {
            if (flag) {
                Pipe pipe = PipeFactory.createPipe(PipeFactory.PipeType.SNAKE, this);
                this.pipes.put(pipe.startingPosition, pipe);
            } else {
                Pipe pipe = PipeFactory.createPipe(PipeFactory.PipeType.LADDER, this);
                this.pipes.put(pipe.startingPosition, pipe);
            }
            flag = !flag;
        }
    }

    public boolean isWinningPosition(Player player, int turn) {
        return player.getCurrentPosition() == ((boardSize * boardSize) - 1);
    }

    public void makeMove(Player currentPlayer, int diceNumber) {
        int nextPosition = currentPlayer.getCurrentPosition() + diceNumber;
        if(nextPosition>=(boardSize*boardSize)) return;
        if(pipes.containsKey(nextPosition)){
            currentPlayer.setCurrentPosition(pipes.get(nextPosition).endingPosition);
        } else{
            currentPlayer.setCurrentPosition(nextPosition);
        }
        System.out.println("Moved by: "+currentPlayer.getName()+ " updated position: "+currentPlayer.getCurrentPosition());
    }
}
