package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class Bishop extends Piece {
    public Bishop(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
