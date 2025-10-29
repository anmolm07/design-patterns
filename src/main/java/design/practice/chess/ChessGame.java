package design.practice.chess;

import design.practice.chess.board.Board;
import design.practice.chess.movement.Move;
import design.practice.chess.player.Player;
import design.practice.chess.status.Status;
import design.practice.tictactoe.state.State;

import java.util.ArrayList;

public class ChessGame {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;
    private final ArrayList<Move> moveLogs;
    private boolean isWhitePlayerTurn;

    ChessGame(Player whitePlayer, Player blackPlayer) {
        this.board = new Board();
        this.whitePlayer = whitePlayer;
        whitePlayer.setPlayingWhite(true);
        this.blackPlayer = blackPlayer;
        blackPlayer.setPlayingWhite(false);
        this.moveLogs = new ArrayList<>();
        this.currentPlayer = whitePlayer;
        this.isWhitePlayerTurn = true;
    }

    private void switchPlayer() {
        this.currentPlayer = whitePlayer == this.currentPlayer ? blackPlayer : whitePlayer;
        this.isWhitePlayerTurn = !this.isWhitePlayerTurn;
    }

    public void play() {
        Status gameStatus = Status.Active;
        this.board.displayBoard();
        do {
            Move move = this.currentPlayer.makeMove(this.board, this.isWhitePlayerTurn);
            if(move == null){
                switchPlayer();
                break;
            }
            gameStatus = this.board.makeMove(move);
            this.board.displayBoard();
        } while (gameStatus == Status.Active);
        addStats();
        announceResult();
        this.whitePlayer.showStats();
        this.blackPlayer.showStats();


    }

    private void announceResult() {
        System.out.printf("%s  wins", this.currentPlayer.getName());
    }

    private void addStats() {
        if(this.currentPlayer == this.blackPlayer){
            this.blackPlayer.addBlackWin();
            this.whitePlayer.addBlackLoss();
        }else {
            this.whitePlayer.addWhiteWin();
            this.blackPlayer.addWhiteLoss();
        }
    }

}
