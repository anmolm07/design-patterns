package design.practice.tictactoe;

import design.practice.tictactoe.enums.Position;
import design.practice.tictactoe.enums.State;
import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.player.Player;

public class TicTacToe {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    TicTacToe(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.playerX = player1;
        this.playerO = player2;
        currentPlayer = player2;
        player1.setCurrentSymbol(Symbol.X);
        player2.setCurrentSymbol(Symbol.O);
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == playerX ? playerO : playerX;
    }

    public void play() {
        do {
            switchPlayer();
            board.printBoard();
            Position move = currentPlayer.getStrategy().makeMove(board);
            board.makeMove(move, currentPlayer);
        }while(board.checkState(currentPlayer) == State.Continue);
        board.printBoard();
        State result = board.checkState(currentPlayer);
        addStats(result);
        announceResult(result);
        playerX.setCurrentSymbol(Symbol.EMPTY);
        playerO.setCurrentSymbol(Symbol.EMPTY);

    }

    private void announceResult(State result) {
        if (result == State.XWinning) {
            System.out.println("Player X wins!");
        } else if (result == State.OWinning) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }


    private void addStats(State result) {
        if (result == State.XWinning) {
            playerX.addXWin();
            playerO.addOLoss();
        } else if (result == State.OWinning) {
            playerO.addOWin();
            playerX.addXLoss();
        } else {
            playerX.addXDraw();
            playerO.addODraw();
        }
    }


}
