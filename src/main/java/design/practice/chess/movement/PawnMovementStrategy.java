package design.practice.chess.movement;

import design.practice.chess.board.Board;

public class PawnMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        int startRow = move.getStartCell().getRow();
        int startCol = move.getStartCell().getCol();
        int endRow = move.getEndCell().getRow();
        int endCol = move.getEndCell().getCol();

        boolean isWhite = move.getStartCell().getPiece().isWhite();

        int direction = isWhite ? -1 : 1;
        boolean isStartRow = isWhite ? startRow == 6 : startRow == 1;

        if (startCol == endCol) {
            if (endRow - startRow == direction) {
                return move.getEndCell().getPiece() == null;
            }
            if (isStartRow && endRow - startRow == 2 * direction) {
                return move.getEndCell().getPiece() == null;
            }
        }

        if (Math.abs(endCol - startCol) == 1 && endRow - startRow == direction) {
            return move.getEndCell().getPiece() != null &&
                   move.getEndCell().getPiece().isWhite() != isWhite;
        }

        return false;
    }
}
