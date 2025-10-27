package design.practice.tictactoe.strategy;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

public interface PlayerStrategy {
    Move makeMove(Board Board, Symbol symbol);
    String getPlayerName();
}
