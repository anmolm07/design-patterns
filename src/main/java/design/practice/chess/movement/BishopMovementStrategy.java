package design.practice.chess.movement;

import design.practice.chess.board.Board;
import design.practice.chess.board.Cell;

public class BishopMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        Cell start = move.getStartCell();
        Cell end = move.getEndCell();

        int dx = Math.abs(start.getRow() - end.getRow());
        int dy = Math.abs(start.getCol() - end.getCol());

        boolean isDiagonal = dx == dy;
        boolean pathClear = MovementUtils.isPathClear(board, start, end);
        boolean validTarget = MovementUtils.isOpponentOrEmpty(start, end);

        return isDiagonal && pathClear && validTarget;
    }
}