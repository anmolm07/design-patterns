package design.practice.tictactoe.algo;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.state.State;

import static design.practice.tictactoe.state.CheckState.checkState;


public class MediumAlgo implements MachineAlgo {

    @Override
    public Move findNextMove(Board board, Symbol symbol) {
        Move winningMove = findImmediateWin(board, symbol);
        if (winningMove != null) return winningMove;

        // 2. Try to block opponent's win
        Move blockMove = findImmediateWin(board, symbol == Symbol.X ? Symbol.O : Symbol.X);
        if (blockMove != null) return blockMove;

        // 3. Strategic move (center, corners, then any empty)
        return findStrategicMove(board.getGrid());
    }

    private Move findImmediateWin(Board board, Symbol symbol) {
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Move move = new Move(i, j);
                if (board.isValidMove(move)) {
                    board.makeMove(move, symbol);
                    if (checkState(board, symbol) == State.Winning) {
                        board.undoLastMove(); // undo
                        return new Move(i, j);
                    }
                    board.undoLastMove(); // undo
                }
            }
        }
        return null;
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
