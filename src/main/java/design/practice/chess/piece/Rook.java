package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class Rook extends Piece {
    public Rook(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
