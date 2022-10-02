package entities;

import services.DiceService;
import services.RoolingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private ArrayList<Player> players;
    private DiceService diceService;
    private int turn;

    public Game(int boardSize, int numOfPlayers, RoolingStrategy roolingStrategy) {
        this.board = new Board(boardSize);
        Scanner scanner = new Scanner(System.in);
        this.players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name of player: " + (i + 1));
            String playerName = scanner.next();
            this.players.add(Player.Builder.getInstance()
                    .setName(playerName)
                    .build());
        }
        this.diceService = DiceService.getInstance(roolingStrategy);
        this.turn = 0;
    }

    public Player play() {
        Player currentPlayer = players.get(0);
        while (!board.isWinningPosition(currentPlayer, turn)) {
            int diceNumber = diceService.rollDice();
            currentPlayer = players.get(turn % players.size());
            board.makeMove(currentPlayer, diceNumber);
            turn++;
        }
        return currentPlayer;
    }

}
