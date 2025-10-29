package design.practice.chess.movement;

import design.practice.chess.board.Board;

public class KingMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        int dx = Math.abs(move.getStartCell().getRow() - move.getEndCell().getRow());
        int dy = Math.abs(move.getStartCell().getCol() - move.getEndCell().getCol());
        return dx <= 1 && dy <= 1  && MovementUtils.isOpponentOrEmpty(move.getStartCell(), move.getEndCell());
    }
}