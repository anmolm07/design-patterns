package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public class Pawn extends Piece {
    public Pawn(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        super(isWhitePiece, movementStrategy,symbol);
    }
}
