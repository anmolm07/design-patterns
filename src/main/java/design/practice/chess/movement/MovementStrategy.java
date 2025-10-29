package design.practice.chess.movement;

import design.practice.chess.board.Board;

public interface MovementStrategy {
  boolean canMove(Board board, Move move);
}