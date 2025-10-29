package design.practice.chess.movement;

import design.practice.chess.board.Board;
import design.practice.chess.board.Cell;
import design.practice.chess.piece.Piece;

public class MovementUtils {
    public static boolean isPathClear(Board board, Cell start, Cell end) {
        int rowStep = Integer.compare(end.getRow(), start.getRow());
        int colStep = Integer.compare(end.getCol(), start.getCol());

        int currentRow = start.getRow() + rowStep;
        int currentCol = start.getCol() + colStep;

        while (currentRow != end.getRow() || currentCol != end.getCol()) {
            if (board.getCell(currentRow, currentCol).getPiece() != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }
        return true;
    }

    public static boolean isOpponentOrEmpty(Cell start, Cell end) {
        Piece startPiece = start.getPiece();
        Piece endPiece = end.getPiece();
        return endPiece == null || startPiece.isWhite() != endPiece.isWhite();
    }
}