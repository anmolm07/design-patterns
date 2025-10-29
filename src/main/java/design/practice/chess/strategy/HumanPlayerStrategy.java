package design.practice.chess.strategy;

import design.practice.chess.board.Board;
import design.practice.chess.board.Cell;
import design.practice.chess.movement.Move;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final String playerName;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public Move makeMove(Board board, boolean isWhiteChance) {
        while (true) {
            System.out.printf("Player - %s, Enter your move (e.g., e2 e4), exit to resign: ", this.playerName);
            try {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Game ended.");
                    return null;
                }

                String[] parts = input.split(" ");
                if (parts.length != 2 || !isValidInput(parts[0]) || !isValidInput(parts[1])) {
                    System.out.println("Invalid input. Please enter moves like 'e2 e4'.");
                    continue;
                }
                int startRow = 8 - Character.getNumericValue(parts[0].charAt(1));
                int startCol = parts[0].charAt(0) - 'a';
                int endRow = 8 - Character.getNumericValue(parts[1].charAt(1));
                int endCol = parts[1].charAt(0) - 'a';

                Cell startCell = board.getCell(startRow, startCol);
                Cell endCell = board.getCell(endRow, endCol);
                Move move = new Move(startCell, endCell);

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


    private static boolean isValidInput(String pos) {
        return pos.length() == 2 &&
                pos.charAt(0) >= 'a' && pos.charAt(0) <= 'h' &&
                pos.charAt(1) >= '1' && pos.charAt(1) <= '8';
    }

    public String getPlayerName() {
        return playerName;
    }
}
