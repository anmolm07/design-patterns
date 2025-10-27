package design.practice.tictactoe.strategy;

import design.practice.tictactoe.Board;
import design.practice.tictactoe.algo.MachineAlgo;
import design.practice.tictactoe.enums.Move;
import design.practice.tictactoe.enums.Symbol;

public class ComputerEasyStrategy implements PlayerStrategy {
    private final MachineAlgo machineAlgo;
    private final String playerName;

    public ComputerEasyStrategy(MachineAlgo machineAlgo, String playerName) {
        this.machineAlgo = machineAlgo;
        this.playerName = playerName;
    }

    @Override
    public Move makeMove(Board board, Symbol symbol) {
        Move move = this.machineAlgo.findNextMove(board.getGrid(), symbol);
        System.out.printf("%s , enter your move (row and column), you are %s : %d %d\n",
                this.playerName, symbol.toString(), move.row(), move.col());

        return move;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }
}
