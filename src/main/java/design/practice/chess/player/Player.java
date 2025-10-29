package design.practice.chess.player;

import design.practice.chess.board.Board;
import design.practice.chess.movement.Move;
import design.practice.chess.stats.Statistics;
import design.practice.chess.strategy.PlayerStrategy;

public class Player {
    private final Statistics stats;
    private final PlayerStrategy playerStrategy;
    private boolean isPlayingWhite;


    public Player(String name, PlayerStrategy playerStrategy) {
        this.stats = new Statistics();
        this.playerStrategy = playerStrategy;
        this.isPlayingWhite = false;
        PlayersList.addPlayer(this);
    }

    public String getName(){
        return this.playerStrategy.getPlayerName();
    }

    public void showStats() {
        System.out.println("Showing stats for  : " + getName());
        this.stats.showStats();
    }

    public void showFullStats() {
        System.out.println("Showing full stats for : " + getName());
        this.stats.showFullStats();
    }

    public void addWhiteWin() {
        this.stats.addWhiteWin();
    }

    public void addBlackWin() {
        this.stats.addBlackWin();
    }

    public void addWhiteLoss() {
        this.stats.addWhiteLoss();
    }

    public void addBlackLoss() {
        this.stats.addBlackLoss();
    }

    public void addWhiteDraw() {
        this.stats.addWhiteDraw();
    }

    public void addBlackDraw() {
        this.stats.addBlackDraw();
    }

    public void setPlayingWhite(boolean playingWhite) {
        isPlayingWhite = playingWhite;
    }

    public Move makeMove(Board board, boolean isPlayingWhite) {
        return this.playerStrategy.makeMove(board, isPlayingWhite);
    }
}
