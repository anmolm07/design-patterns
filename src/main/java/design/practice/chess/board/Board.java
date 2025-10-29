package design.practice.chess.board;

import design.practice.chess.movement.Move;
import design.practice.chess.piece.Piece;
import design.practice.chess.piece.PieceFactory;
import design.practice.chess.status.Status;

import static design.practice.chess.piece.Pieces.*;

public class Board {
    private Cell[][] board;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Cell[8][8];

        setPieceRow(0, false);
        setPawnRow(1, false);
        setPieceRow(7, true);
        setPawnRow(6, true);

        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Cell(row, col, null);
            }
        }

    }

    private void setPieceRow(int row, boolean isWhite) {
        board[row][0] = new Cell(row, 0, PieceFactory.createPiece(Rook, isWhite));
        board[row][1] =
                new Cell(row, 1, PieceFactory.createPiece(Knight, isWhite));
        board[row][2] =
                new Cell(row, 2, PieceFactory.createPiece(Bishop, isWhite));
        board[row][3] =
                new Cell(row, 3, PieceFactory.createPiece(Queen, isWhite));
        board[row][4] = new Cell(row, 4, PieceFactory.createPiece(King, isWhite));
        board[row][5] =
                new Cell(row, 5, PieceFactory.createPiece(Bishop, isWhite));
        board[row][6] =
                new Cell(row, 6, PieceFactory.createPiece(Knight, isWhite));
        board[row][7] = new Cell(row, 7, PieceFactory.createPiece(Rook, isWhite));
    }

    private void setPawnRow(int row, boolean isWhite) {
        for (int j = 0; j < 8; j++) {
            board[row][j] = new Cell(row, j, PieceFactory.createPiece(Pawn, isWhite));
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isValidMove(Move move) {
        Cell startCell = move.getStartCell();
        Cell endCell = move.getEndCell();
        return startCell.getPiece().getMovementStrategy().canMove(this, move);
    }

    public Status makeMove(Move move) {
        Cell startCell = move.getStartCell();
        Cell endCell = move.getEndCell();

        Piece startPiece = startCell.getPiece();
        Piece endPiece = endCell.getPiece();

        if (endPiece == null) {
            startCell.setPiece(null);
            endCell.setPiece(startPiece);
        } else {
            if (endPiece.getSymbol().equalsIgnoreCase("k")) {
                return Status.Completed;
            } else {
                endPiece.setKilled(true);
                startCell.setPiece(null);
                endCell.setPiece(startPiece);
            }
        }
        return Status.Active;
    }

    public void displayBoard() {
        System.out.println("  a b c d e f g h");
        for (int row = 0; row <= 7; row++) {
            System.out.print((8 - row) + " ");
            for (int col = 0; col < 8; col++) {
                Cell cell = board[row][col];
                if (cell.getPiece() == null) {
                    System.out.print(". ");
                } else {
                    String symbol = cell.getPiece().getSymbol(); // e.g., "K", "Q", "P"
                    String display = cell.getPiece().isWhite() ? symbol.toUpperCase() : symbol.toLowerCase();
                    System.out.print(display + " ");
                }
            }
            System.out.println((8 - row));
        }
        System.out.println("  a b c d e f g h");
    }


}