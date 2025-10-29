package design.practice.chess.movement;

import design.practice.chess.board.Board;
import design.practice.chess.board.Cell;

public class RookMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        Cell start = move.getStartCell();
        Cell end = move.getEndCell();

        boolean isStraight = start.getRow() == end.getRow() || start.getCol() == end.getCol();
        boolean pathClear = MovementUtils.isPathClear(board, start, end);
        boolean validTarget = MovementUtils.isOpponentOrEmpty(start, end);

        return isStraight && pathClear && validTarget;
    }
}