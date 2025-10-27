package design.practice.tictactoe;

import design.practice.tictactoe.enums.Position;
import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.player.Player;
import design.practice.tictactoe.enums.State;

public class Board {
    private final int size;
    private Symbol[][] grid;

    Board(int size) {
        this.size = size;
        grid = new Symbol[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid[row][column] = Symbol.EMPTY;
            }
        }
    }

    void makeMove(Position pos, Player currentPlayer) {
        if (!isValidMove(pos)) {
            throw new IllegalArgumentException("Invalid move");
        }
        grid[pos.row()][pos.col()] = currentPlayer.getCurrentSymbol();
    }

    public boolean isValidMove(Position pos) {
        return pos.row() >= 0 && pos.row() < size
                && pos.col() >= 0 && pos.col() < size
                && grid[pos.row()][pos.col()] == Symbol.EMPTY;
    }


    public State checkState(Player currentPlayer) {
        if (checkRows() || checkColumns() || checkDiagonal()) {
            return getWinner(currentPlayer);
        } else if (checkDraw()) {
            return State.Draw;
        }
        return State.Continue;
    }

    private State getWinner(Player currentPlayer) {
        return currentPlayer.getCurrentSymbol() == Symbol.X ? State.XWinning : State.OWinning;
    }

    private boolean checkRows() {
        for (int row = 0; row < size; row++) {
            if (grid[row][0] != Symbol.EMPTY && checkRow(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int column = 0; column < size; column++) {
            if (grid[0][column] != Symbol.EMPTY && checkColumn(column)) {
                return true;
            }
        }
        return false;
    }


    private boolean checkRow(int row) {
        Symbol first = grid[row][0];
        for (int column = 0; column < size; column++) {
            if (grid[row][column] != first) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int column) {
        Symbol first = grid[0][column];
        for (int row = 0; row < size; row++) {
            if (grid[row][column] != first) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal() {
        Symbol first = grid[size / 2][size / 2];
        if(first == Symbol.EMPTY) {
            return false;
        }
        boolean firstDiagonal = true;
        boolean secondDiagonal = true;
        for (int diagonal = 0; diagonal < size; diagonal++) {
            if (grid[diagonal][diagonal] != first) {
                firstDiagonal = false;
            }
        }
        for (int diagonal = 0; diagonal < size; diagonal++) {
            if (grid[diagonal][size - diagonal - 1] != first) {
                secondDiagonal = false;
            }
        }
        return firstDiagonal || secondDiagonal;
    }


    private boolean checkDraw() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (grid[row][column] == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
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
}
