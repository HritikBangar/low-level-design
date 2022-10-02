import entities.Game;
import entities.Player;
import services.FairRooling;

public class SnakeAndLadder {

    public static void main(String[] args){
        System.out.println("Creating Game");
        Game game = new Game(10, 2, new FairRooling());
        Player winner = game.play();
        System.out.println("Winner is :-"+winner.getName());
    }

}
