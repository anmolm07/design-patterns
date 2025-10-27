package design.practice.tictactoe;

import design.practice.tictactoe.algo.EasyAlgo;
import design.practice.tictactoe.algo.MediumAlgo;
import design.practice.tictactoe.algo.MachineAlgo;
import design.practice.tictactoe.player.Player;
import design.practice.tictactoe.strategy.ComputerStrategy;
import design.practice.tictactoe.strategy.HumanPlayerStrategy;

public class Main {

    public static void main(String[] args) {
        MachineAlgo easyAlgo = new EasyAlgo();
        MachineAlgo MediumAlgo = new MediumAlgo();
        Player easyMode = new Player(new ComputerStrategy(easyAlgo, "Machine Easy Mode"));
        Player mediumMode = new Player(new ComputerStrategy(MediumAlgo, "Machine Medium Mode"));
        Player player1 = new Player(new HumanPlayerStrategy("Player Number 1"));
        Player player2 = new Player(new HumanPlayerStrategy("Player Number 2"));
        TicTacToe game = new TicTacToe(3, player1, mediumMode);
        game.play();
        System.out.println();
        mediumMode.showStats();
        System.out.println();
        player1.showStats();
        System.out.println();
        easyMode.showStats();
        System.out.println();
        player2.showStats();

    }
}
