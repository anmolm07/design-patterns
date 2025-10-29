package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class King extends Piece {
    public King(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
