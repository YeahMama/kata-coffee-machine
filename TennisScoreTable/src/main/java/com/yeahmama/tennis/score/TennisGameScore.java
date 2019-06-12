package com.yeahmama.tennis.score;

import java.util.ArrayList;
import java.util.Arrays;

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

    public String toTennisScore(int score) {
        switch(score) {
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
        }

        return "0";
    }

    public void displayGameScoreTable() {
        System.out.println("Game score");

        TennisGameTable tennisGameTable = new TennisGameTable();

        tennisGameTable.setShowVerticalLines(true);
        tennisGameTable.setHeaders(toArrayString(this.gameScoreHeader));
        tennisGameTable.addRow(toArrayString(this.gameScorePlayerOneRow));
        tennisGameTable.addRow(toArrayString(this.gameScorePlayerTwoRow));
        tennisGameTable.addRow(toArrayString(this.gameScoreWinnerRow));

        tennisGameTable.print();
    }

    public String[] toArrayString(ArrayList<String> arrayList) {
        return Arrays.copyOf(arrayList.toArray(), arrayList.toArray().length, String[].class);
    }

    public boolean isOver() {
        return this.playerOneScore == 4 || this.playerTwoScore == 4;
    }

    public boolean isNotOver() {
        return (! isOver());
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public String getWinner() {
        return winner;
    }

    public ArrayList<String> getGameScoreHeader() {
        return gameScoreHeader;
    }

    public ArrayList<String> getGameScorePlayerOneRow() {
        return gameScorePlayerOneRow;
    }

    public ArrayList<String> getGameScorePlayerTwoRow() {
        return gameScorePlayerTwoRow;
    }

    public ArrayList<String> getGameScoreWinnerRow() {
        return gameScoreWinnerRow;
    }

}
