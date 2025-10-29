package design.practice.chess.movement;

import design.practice.chess.board.Cell;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }
}