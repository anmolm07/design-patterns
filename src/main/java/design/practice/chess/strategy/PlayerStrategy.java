package design.practice.chess.strategy;


import design.practice.chess.board.Board;
import design.practice.chess.movement.Move;

public interface PlayerStrategy {
    Move makeMove(Board board, boolean isWhiteChance);
    public String getPlayerName();
}
