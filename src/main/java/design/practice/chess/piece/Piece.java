package design.practice.chess.piece;

import design.practice.chess.movement.MovementStrategy;

public abstract class Piece {
    private boolean isWhitePiece;
    private boolean killed = false;
    private String symbol;
    private MovementStrategy movementStrategy;

    public Piece(boolean isWhitePiece, MovementStrategy movementStrategy, String symbol) {
        this.isWhitePiece = isWhitePiece;
        this.movementStrategy = movementStrategy;
        this.symbol = symbol;
    }

    public boolean isWhite() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public String getSymbol() {
        return symbol;
    }
}
