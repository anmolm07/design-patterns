package design.practice.tictactoe.player;

import design.practice.tictactoe.enums.Symbol;
import design.practice.tictactoe.stats.Statistics;
import design.practice.tictactoe.strategy.PlayerStrategy;

public class Player {
    private PlayerStrategy strategy;
    private Statistics stats;
    private Symbol currentSymbol;

    public PlayerStrategy getStrategy() {
        return strategy;
    }

    public Player(PlayerStrategy strategy) {
        this.strategy = strategy;
        this.stats = new Statistics();
        this.currentSymbol = Symbol.EMPTY;
        PlayersList.addPlayer(this);
    }

    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }

    public void setCurrentSymbol(Symbol currentSymbol) {
        this.currentSymbol = currentSymbol;
    }

    public void showStats(){
        System.out.println("SHOWING STATS FOR :" + this.strategy.getPlayerName());
        this.stats.showStats();
    }

    public void addXWin() {
        this.stats.addXWin();
    }

    public void addOWin() {
        this.stats.addOWin();
    }

    public void addXLoss() {
        this.stats.addXLoss();
    }

    public void addOLoss() {
        this.stats.addOLoss();
    }

    public void addXDraw() {
        this.stats.addXDraw();
    }

    public void addODraw() {
        this.stats.addODraw();
    }
}
