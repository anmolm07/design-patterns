package design.practice.tictactoe.strategy;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final Scanner scanner;
    private final String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove(Board board, Symbol symbol) {
        while (true) {
            System.out.printf("%s, enter your move (row and column), you are %s : ", this.playerName,symbol.toString());
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Move move = new Move(row, col);
                if (board.isValidMove(move)) {
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
        return this.playerName;
    }
}