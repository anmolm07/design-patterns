package design.practice.tictactoe.algo;

import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

public interface MachineAlgo {
    Move findNextMove(Symbol[][] board, Symbol symbol);
}
