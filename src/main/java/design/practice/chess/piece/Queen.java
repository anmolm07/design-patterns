package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class Queen extends Piece {
    public Queen(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
