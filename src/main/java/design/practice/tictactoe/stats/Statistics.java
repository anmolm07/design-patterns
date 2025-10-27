package design.practice.tictactoe.stats;

public class Statistics {

    private int totalNumber;
    private int totalWins;
    private int totalLosses;
    private int totalDraws;

    private int playedAsX;
    private int playedAsO;
    private int winsAsX;
    private int winsAsO;
    private int drawsAsX;
    private int drawsAsO;
    private int lossesAsX;
    private int lossesAsO;

    public Statistics() {
        this.totalNumber = 0;
        this.totalWins = 0;
        this.totalLosses = 0;
        this.totalDraws = 0;
        this.playedAsX = 0;
        this.playedAsO = 0;
        this.winsAsX = 0;
        this.winsAsO = 0;
        this.drawsAsX = 0;
        this.drawsAsO = 0;
        this.lossesAsX = 0;
        this.lossesAsO = 0;
    }

    private void addWin() {
        addMatch();
        totalWins++;
    }

    private void addLoss() {
        addMatch();
        totalLosses++;
    }

    private void addDraw() {
        addMatch();
        totalDraws++;
    }

    private void addMatch() {
        totalNumber++;
    }

    private void addXMatch() {
        playedAsX++;
    }

    private void addOMatch() {
        playedAsO++;
    }

    public void addXWin() {
        addWin();
        addXMatch();
        winsAsX++;
    }

    public void addOWin() {
        addWin();
        addOMatch();
        winsAsO++;
    }

    public void addXLoss() {
        addLoss();
        addXMatch();
        lossesAsX++;
    }

    public void addOLoss() {
        addLoss();
        addOMatch();
        lossesAsO++;
    }

    public void addXDraw() {
        addDraw();
        addXMatch();
        drawsAsX++;
    }

    public void addODraw() {
        addDraw();
        addOMatch();
        drawsAsO++;
    }

    public void showStats() {
        System.out.printf("Total Number of Matches Played: %d\n", totalNumber);
        System.out.printf("Total Wins: %d\n", totalWins);
        System.out.printf("Total Losses: %d\n", totalLosses);
        System.out.printf("Total Draws: %d\n", totalDraws);
    }
}
