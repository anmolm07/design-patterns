package design.practice.tictactoe;

import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.player.Player;
import design.practice.tictactoe.player.PlayersList;
import design.practice.tictactoe.stats.Statistics;
import design.practice.tictactoe.strategy.HumanPlayerStrategy;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player(new HumanPlayerStrategy("Player Number 1"));
        Player player2 = new Player(new HumanPlayerStrategy("Player Number 2"));
        TicTacToe game = new TicTacToe(3,player1,player2);
        game.play();
        System.out.println();
        player2.showStats();
        player1.showStats();
    }
}
