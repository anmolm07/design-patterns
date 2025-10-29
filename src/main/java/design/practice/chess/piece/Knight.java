package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class Knight extends Piece {
    public Knight(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
