package design.practice.tictactoe.state;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Symbol;

public class CheckState {

    public static State checkState(Board board, Symbol symbol) {
        Symbol[][] grid = board.getGrid();
        int size = board.getSize();
        if (checkRowsAndColumnsWinning(grid, size, symbol) || checkDiagonalsWinning(grid, size, symbol)) {
            return State.Winning;
        }else if(checkDraw(grid, size)){
            return State.Draw;
        }
        return State.Continue;
    }

    private static boolean checkDraw(Symbol [][] grid, int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (grid[row][column] == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRowsAndColumnsWinning(Symbol[][] grid, int size, Symbol symbol) {
        for (int i = 0; i < size; i++) {
            if (isLineWin(grid, size, symbol, i, true) || isLineWin(grid, size, symbol, i, false)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLineWin(Symbol[][] board, int size, Symbol symbol, int index, boolean isRow) {
        for (int i = 0; i < size; i++) {
            Symbol cell = isRow ? board[index][i] : board[i][index];
            if (!(symbol == cell)) return false;
        }
        return true;
    }

    public static boolean checkDiagonalsWinning(Symbol[][] grid, int size, Symbol symbol) {
        return isDiagonalWin(grid, size, symbol, true) || isDiagonalWin(grid, size, symbol, false);
    }

    public static boolean isDiagonalWin(Symbol[][] board, int size, Symbol symbol, boolean mainDiagonal) {
        for (int i = 0; i < size; i++) {
            Symbol cell = mainDiagonal ? board[i][i] : board[i][size - 1 - i];
            if (!(symbol == cell)) return false;
        }
        return true;
    }

}
