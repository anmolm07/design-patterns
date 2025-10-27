package design.practice.tictactoe.algo;

import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

public class EasyAlgo implements MachineAlgo {

    @Override
    public Move findNextMove(Symbol[][] board, Symbol symbol) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Symbol.EMPTY) {
                    return new Move(i, j);
                }
            }
        }
        return null;
    }
}
