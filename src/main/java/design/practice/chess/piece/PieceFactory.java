package design.practice.chess.piece;

public class PieceFactory {
    public static Piece createPiece(Pieces pieceType, boolean isWhitePiece) {
        if (pieceType == null) {
            throw new IllegalArgumentException("Piece type cannot be null");
        }
        return pieceType.create(isWhitePiece);
    }
}