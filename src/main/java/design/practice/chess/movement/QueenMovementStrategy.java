package design.practice.chess.movement;

import design.practice.chess.board.Board;

public class QueenMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        return new RookMovementStrategy().canMove(board, move) ||
               new BishopMovementStrategy().canMove(board, move);
    }
}