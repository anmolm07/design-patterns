package design.practice.tictactoe;

import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.state.State;
import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.player.Player;

import static design.practice.tictactoe.state.CheckState.checkState;

public class TicTacToe {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
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
        board.printBoard();
        do {
            switchPlayer();
            Move move = currentPlayer.getStrategy().makeMove(board, currentPlayer.getCurrentSymbol());
            board.makeMove(move, currentPlayer.getCurrentSymbol());
            board.printBoard();
        } while (checkState(board, currentPlayer.getCurrentSymbol()) == State.Continue);
        State result = checkState(board, currentPlayer.getCurrentSymbol());
        addStats(result);
        announceResult(result);
        playerX.setCurrentSymbol(Symbol.EMPTY);
        playerO.setCurrentSymbol(Symbol.EMPTY);

    }

    private void announceResult(State result) {
        if (result == State.Winning) {
            System.out.printf("%s wins!\n", currentPlayer.getStrategy().getPlayerName());
        } else {
            System.out.println("It's a draw!");
        }
    }


    private void addStats(State result) {
        if (result == State.Winning && currentPlayer == playerX) {
            playerX.addXWin();
            playerO.addOLoss();
        } else if (result == State.Winning && currentPlayer == playerO) {
            playerO.addOWin();
            playerX.addXLoss();
        } else {
            playerX.addXDraw();
            playerO.addODraw();
        }
    }


}
