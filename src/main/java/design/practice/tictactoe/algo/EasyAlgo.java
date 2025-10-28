package design.practice.tictactoe.algo;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

public class EasyAlgo implements MachineAlgo {

    @Override
    public Move findNextMove(Board board, Symbol symbol) {
        int size = board.getSize();
        Symbol[][] grid = board.getGrid();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    return new Move(i, j);
                }
            }
        }
        return null;
    }
}
