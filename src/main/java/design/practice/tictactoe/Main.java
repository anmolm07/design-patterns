package design.practice.tictactoe;

import design.practice.tictactoe.algo.EasyAlgo;
import design.practice.tictactoe.player.Player;
import design.practice.tictactoe.strategy.ComputerEasyStrategy;
import design.practice.tictactoe.strategy.HumanPlayerStrategy;

public class Main {

    public static void main(String[] args) {
        EasyAlgo easyAlgo = new EasyAlgo();
        Player easyMode = new Player(new ComputerEasyStrategy(easyAlgo,"Machine Easy Mode"));
        Player player1 = new Player(new HumanPlayerStrategy("Player Number 1"));
        TicTacToe game = new TicTacToe(3,player1,easyMode);
        game.play();
        System.out.println();
        easyMode.showStats();
        System.out.println();
        player1.showStats();
    }
}
