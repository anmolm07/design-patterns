package design.practice.tictactoe;

import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

import java.util.Stack;

public class Board {
    private final int size;
    private final Symbol[][] grid;
    private final Stack<Move> lastMove;

    Board(int size) {
        this.size = size;
        grid = new Symbol[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid[row][column] = Symbol.EMPTY;
            }
        }
        lastMove = new Stack<>();
    }

    public void makeMove(Move move, Symbol symbol) {
        if (!isValidMove(move)) {
            throw new IllegalArgumentException("Invalid move");
        }
        grid[move.row()][move.col()] = symbol;
        lastMove.push(move);
    }

    public void undoLastMove(){
        if(lastMove.isEmpty()) return;
        Move move = lastMove.peek();
        grid[move.row()][move.col()] = Symbol.EMPTY;
        lastMove.pop();
    }

    public boolean isValidMove(Move move) {
        return move.row() >= 0 && move.row() < size
                && move.col() >= 0 && move.col() < size
                && grid[move.row()][move.col()] == Symbol.EMPTY;
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public Symbol[][] getGrid() {
        return grid;
    }
}
