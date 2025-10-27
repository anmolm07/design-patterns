package design.practice.tictactoe.strategy;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Position;
import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final Scanner scanner;
    private final String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board Board) {
        while (true) {
            System.out.printf("%s, enter your move (row [0-2] and column [0-2]): ", playerName);
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);
                if (Board.isValidMove(move)) {
                    return move;
                }
                System.out.println("Invalid move. Try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter row and column as numbers.");
                scanner.nextLine();
            }
        }
    }

    public String getPlayerName() {
        return playerName;
    }
}