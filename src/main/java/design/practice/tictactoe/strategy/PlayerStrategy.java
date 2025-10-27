package design.practice.tictactoe.strategy;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.enums.Position;

public interface PlayerStrategy {
    Position makeMove(Board Board);
    public String getPlayerName();
}
