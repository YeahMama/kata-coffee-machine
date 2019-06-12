package com.yeahmama.tennis.score;

import java.util.ArrayList;

import static com.yeahmama.tennis.utils.ArrayListUtils.toArrayString;
import static com.yeahmama.tennis.utils.TennisUtils.toTennisScore;

public class TennisGameScore {

    private int playerOneScore;
    private int playerTwoScore;

    private String winner;

    private ArrayList<String> gameScoreHeader;
    private ArrayList<String> gameScorePlayerOneRow;
    private ArrayList<String> gameScorePlayerTwoRow;
    private ArrayList<String> gameScoreWinnerRow;

    public TennisGameScore() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;

        this.gameScoreHeader = new ArrayList<>();
        this.gameScorePlayerOneRow = new ArrayList<>();
        this.gameScorePlayerTwoRow = new ArrayList<>();
        this.gameScoreWinnerRow = new ArrayList<>();

        init();
    }

    private void init() {
        this.gameScoreHeader.add("");
        this.gameScoreHeader.add("Start the game");

        this.gameScorePlayerOneRow.add("Player 1");
        this.gameScorePlayerOneRow.add("0");

        this.gameScorePlayerTwoRow.add("Player 2");
        this.gameScorePlayerTwoRow.add("0");

        this.gameScoreWinnerRow.add("");
        this.gameScoreWinnerRow.add("");
    }

    public void addPointPlayerOne() {
        this.playerOneScore += 1;
        this.winner = "Player 1";
    }

    public void addPointPlayerTwo() {
        this.playerTwoScore += 1;
        this.winner = "Player 2";
    }

    public void addPointCol() {
        this.gameScoreHeader.add(this.winner + " wins 1 point");
        this.gameScorePlayerOneRow.add(toTennisScore(this.playerOneScore));
        this.gameScorePlayerTwoRow.add(toTennisScore(this.playerTwoScore));
        this.gameScoreWinnerRow.add("");
    }

    public void addGameOverCol() {
        this.gameScoreHeader.add(this.winner + " wins 1 point");
        this.gameScorePlayerOneRow.add("0");
        this.gameScorePlayerTwoRow.add("0");
        this.gameScoreWinnerRow.add(this.winner + " wins the game");
    }

    public void display() {
        System.out.println("Game score");

        TennisGameTable tennisGameTable = new TennisGameTable();

        tennisGameTable.setShowVerticalLines(true);
        tennisGameTable.setHeaders(toArrayString(this.gameScoreHeader));
        tennisGameTable.addRow(toArrayString(this.gameScorePlayerOneRow));
        tennisGameTable.addRow(toArrayString(this.gameScorePlayerTwoRow));
        tennisGameTable.addRow(toArrayString(this.gameScoreWinnerRow));

        tennisGameTable.print();
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

    String getWinner() {
        return winner;
    }

    ArrayList<String> getGameScoreHeader() {
        return gameScoreHeader;
    }

    ArrayList<String> getGameScorePlayerOneRow() {
        return gameScorePlayerOneRow;
    }

    ArrayList<String> getGameScorePlayerTwoRow() {
        return gameScorePlayerTwoRow;
    }

    ArrayList<String> getGameScoreWinnerRow() {
        return gameScoreWinnerRow;
    }

}
