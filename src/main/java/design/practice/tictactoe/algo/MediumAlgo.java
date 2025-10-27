package design.practice.tictactoe.algo;

import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;


public class MediumAlgo implements MachineAlgo {

    @Override
    public Move findNextMove(Symbol[][] board, Symbol symbol) {
        int n = board.length;

        Move winningMove = findImmediateWin(board, symbol);
        if (winningMove != null) return winningMove;

        // 2. Try to block opponent's win
        Move blockMove = findImmediateWin(board, symbol == Symbol.X ? Symbol.O : Symbol.X);
        if (blockMove != null) return blockMove;

        // 3. Strategic move (center, corners, then any empty)
        return findStrategicMove(board);
    }

    private Move findImmediateWin(Symbol[][] board, Symbol symbol) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEmpty(board[i][j])) {
                    board[i][j] = symbol;
                    if (isWinning(board, symbol)) {
                        board[i][j] = Symbol.EMPTY; // undo
                        return new Move(i, j);
                    }
                    board[i][j] = Symbol.EMPTY; // undo
                }
            }
        }
        return null;
    }

    private boolean isWinning(Symbol[][] board, Symbol symbol) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (isLineWin(board, symbol, i, true) || isLineWin(board, symbol, i, false)) {
                return true;
            }
        }

        return isDiagonalWin(board, symbol, true) || isDiagonalWin(board, symbol, false);
    }

    private boolean isLineWin(Symbol[][] board, Symbol symbol, int index, boolean isRow) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            Symbol cell = isRow ? board[index][i] : board[i][index];
            if (!(symbol == cell)) return false;
        }
        return true;
    }

    public static boolean isDiagonalWin(Symbol[][] board, Symbol symbol, boolean mainDiagonal) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            Symbol cell = mainDiagonal ? board[i][i] : board[i][n - 1 - i];
            if (!(symbol == cell)) return false;
        }
        return true;
    }

    private static Move findStrategicMove(Symbol[][] board) {
        int n = board.length;

        // Center
        if (isEmpty(board[n / 2][n / 2])) return new Move(n / 2, n / 2);

        // Corners
        Move[] corners = {new Move(0, 0), new Move(0, n - 1), new Move(n - 1, 0), new Move(n - 1, n - 1)};
        for (Move corner : corners) {
            if (isEmpty(board[corner.row()][corner.col()])) return corner;
        }

        // Any empty cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEmpty(board[i][j])) return new Move(i, j);
            }
        }

        return null;
    }

    public static boolean isEmpty(Symbol cell) {
        return cell == Symbol.EMPTY;
    }
}
