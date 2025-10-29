package design.practice.chess.board;

import design.practice.chess.piece.Piece;

public class Cell {
    private final int row, col;
    private String label;
    private Piece piece;

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}