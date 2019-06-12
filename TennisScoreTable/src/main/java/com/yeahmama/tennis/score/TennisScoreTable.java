package com.yeahmama.tennis.score;

import java.util.ArrayList;

import static com.yeahmama.tennis.utils.ArrayListUtils.toArrayString;
import static com.yeahmama.tennis.utils.TennisUtils.toTennisScore;

class TennisScoreTable {

    private TennisScoreTableBuilder tennisScoreTableBuilder;

    private ArrayList<String> gameScoreHeader;
    private ArrayList<String> gameScorePlayerOneRow;
    private ArrayList<String> gameScorePlayerTwoRow;
    private ArrayList<String> gameScoreWinnerRow;

    TennisScoreTable() {
        this.tennisScoreTableBuilder = new TennisScoreTableBuilder();

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

    void addPointCol(String winnerPoint, int playerOneScore, int playerTwoScore) {
        this.gameScoreHeader.add(winnerPoint + " wins 1 point");
        this.gameScorePlayerOneRow.add(toTennisScore(playerOneScore));
        this.gameScorePlayerTwoRow.add(toTennisScore(playerTwoScore));
        this.gameScoreWinnerRow.add("");
    }

    void addGameOverCol(String winnerGame) {
        this.gameScoreHeader.add(winnerGame + " wins 1 point");
        this.gameScorePlayerOneRow.add("0");
        this.gameScorePlayerTwoRow.add("0");
        this.gameScoreWinnerRow.add(winnerGame + " wins the game");
    }

    void display() {
        System.out.println("Game score");

        this.tennisScoreTableBuilder.setShowVerticalLines(true);
        this.tennisScoreTableBuilder.setHeaders(toArrayString(this.gameScoreHeader));
        this.tennisScoreTableBuilder.addRow(toArrayString(this.gameScorePlayerOneRow));
        this.tennisScoreTableBuilder.addRow(toArrayString(this.gameScorePlayerTwoRow));
        this.tennisScoreTableBuilder.addRow(toArrayString(this.gameScoreWinnerRow));

        this.tennisScoreTableBuilder.print();
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
