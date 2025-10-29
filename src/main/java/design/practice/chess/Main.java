package design.practice.chess;

import design.practice.chess.player.Player;
import design.practice.chess.strategy.HumanPlayerStrategy;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", new HumanPlayerStrategy("PLAYER 1"));
        Player player2 = new Player("Player2", new HumanPlayerStrategy("PLAYER 2"));
        ChessGame chessGame = new ChessGame(player1, player2);
        chessGame.play();
    }
}
