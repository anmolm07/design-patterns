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
        System.out.printf("Total number of matches played: %d\n", totalNumber);
        System.out.printf("Total wins: %d\n", totalWins);
        System.out.printf("Total losses: %d\n", totalLosses);
        System.out.printf("Total draws: %d\n", totalDraws);
    }

    public void showFullStats() {
        System.out.printf("Total number of matches played: %d\n", totalNumber);
        System.out.printf("Total wins: %d\n", totalWins);
        System.out.printf("Total losses: %d\n", totalLosses);
        System.out.printf("Total draws: %d\n", totalDraws);
        System.out.printf("Played as X: %d\n", playedAsX);
        System.out.printf("Wins as  X: %d\n", winsAsX);
        System.out.printf("Loss as  X: %d\n", lossesAsX);
        System.out.printf("Draws as  X: %d\n", drawsAsX);
        System.out.printf("Played as O: %d\n", playedAsO);
        System.out.printf("Wins as  O: %d\n", winsAsO);
        System.out.printf("Loss as  O: %d\n", lossesAsO);
        System.out.printf("Draws as  O: %d\n", drawsAsO);
    }
}
