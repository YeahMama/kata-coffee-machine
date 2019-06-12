package com.yeahmama.tennis.score;

public class TennisScore {

    private TennisScoreTable tennisScoreTable;

    private int playerOneScore;
    private int playerTwoScore;

    public TennisScore() {
        this.tennisScoreTable = new TennisScoreTable();

        this.playerOneScore = 0;
        this.playerTwoScore = 0;
    }

    public void addPointPlayerOne() {
        this.playerOneScore += 1;
        this.updateScoreTable("Player 1");
    }

    public void addPointPlayerTwo() {
        this.playerTwoScore += 1;
        this.updateScoreTable("Player 2");
    }

    private void updateScoreTable(String winnerPoint) {
        if (this.isOver()) {
            this.tennisScoreTable.addGameOverCol(winnerPoint);
        } else {
            this.tennisScoreTable.addPointCol(winnerPoint, this.playerOneScore, this.playerTwoScore);
        }
    }

    public void displayScoreTable() {
        this.tennisScoreTable.display();
    }

    public boolean isOver() {
        return this.playerOneScore == 4 || this.playerTwoScore == 4;
    }

    public boolean isNotOver() {
        return (!isOver());
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

}
