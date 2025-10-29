package design.practice.chess.piece;


import design.practice.chess.movement.*;

public enum Pieces {
    King {
        @Override
        public Piece create(boolean isWhite) {
            return new King(isWhite, new KingMovementStrategy(), "K");
        }
    },
    Queen {
        @Override
        public Piece create(boolean isWhite) {
            return new Queen(isWhite, new QueenMovementStrategy(), "Q");
        }
    },
    Bishop {
        @Override
        public Piece create(boolean isWhite) {
            return new Bishop(isWhite, new BishopMovementStrategy(), "B");
        }
    },
    Knight {
        @Override
        public Piece create(boolean isWhite) {
            return new Knight(isWhite, new KnightMovementStrategy(), "K");
        }
    },
    Rook {
        @Override
        public Piece create(boolean isWhite) {
            return new Rook(isWhite, new RookMovementStrategy(), "R");
        }
    },
    Pawn {
        @Override
        public Piece create(boolean isWhite) {
            return new Pawn(isWhite, new PawnMovementStrategy(), "P");
        }
    };

    public abstract Piece create(boolean isWhite);
}

