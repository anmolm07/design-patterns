package design.practice.chess.stats;

public class Statistics {

    private int totalNumber;
    private int totalWins;
    private int totalLosses;
    private int totalDraws;

    private int playedAsWhite;
    private int playedAsBlack;
    private int winsAsWhite;
    private int winsAsBlack;
    private int drawsAsWhite;
    private int drawsAsBlack;
    private int lossesAsWhite;
    private int lossesAsBlack;

    public Statistics() {
        this.totalNumber = 0;
        this.totalWins = 0;
        this.totalLosses = 0;
        this.totalDraws = 0;
        this.playedAsWhite = 0;
        this.playedAsBlack = 0;
        this.winsAsWhite = 0;
        this.winsAsBlack = 0;
        this.drawsAsWhite = 0;
        this.drawsAsBlack = 0;
        this.lossesAsWhite = 0;
        this.lossesAsBlack = 0;
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

    private void addWhiteMatch() {
        playedAsWhite++;
    }

    private void addBlackMatch() {
        playedAsBlack++;
    }

    public void addWhiteWin() {
        addWin();
        addWhiteMatch();
        winsAsWhite++;
    }

    public void addBlackWin() {
        addWin();
        addBlackMatch();
        winsAsBlack++;
    }

    public void addWhiteLoss() {
        addLoss();
        addWhiteMatch();
        lossesAsWhite++;
    }

    public void addBlackLoss() {
        addLoss();
        addBlackMatch();
        lossesAsBlack++;
    }

    public void addWhiteDraw() {
        addDraw();
        addWhiteMatch();
        drawsAsWhite++;
    }

    public void addBlackDraw() {
        addDraw();
        addBlackMatch();
        drawsAsBlack++;
    }

    public void showStats() {
        System.out.printf("Total number of matches played: %d\n", totalNumber);
        System.out.printf("Total wins: %d\n", totalWins);
        System.out.printf("Total losses: %d\n", totalLosses);
        System.out.printf("Total draws: %d\n", totalDraws);
    }

    public void showFullStats() {
        this.showStats();
        System.out.printf("Played as X: %d\n", playedAsWhite);
        System.out.printf("Wins as  X: %d\n", winsAsWhite);
        System.out.printf("Loss as  X: %d\n", lossesAsWhite);
        System.out.printf("Draws as  X: %d\n", drawsAsWhite);
        System.out.printf("Played as O: %d\n", playedAsBlack);
        System.out.printf("Wins as  O: %d\n", winsAsBlack);
        System.out.printf("Loss as  O: %d\n", lossesAsBlack);
        System.out.printf("Draws as  O: %d\n", drawsAsBlack);
    }
}
