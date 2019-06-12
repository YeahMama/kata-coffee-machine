package com.yeahmama.tennis.actor;

import com.yeahmama.tennis.score.TennisScore;

public class TennisReferee {

    private TennisScore tennisScore;

    public TennisReferee() {
        this.tennisScore = new TennisScore();
    }

    public void updatePlayerPoints(int winnerPoint) {
        if (isPlayerOneWinPoint(winnerPoint)) {
            this.tennisScore.addPointPlayerOne();

        } else {
            this.tennisScore.addPointPlayerTwo();
        }
    }

    public void displayGameScore() {
        this.tennisScore.displayScoreTable();
    }

    boolean isPlayerOneWinPoint(int winnerPoint) {
        return winnerPoint % 2 != 0;
    }

    boolean hasAnnouncedTennisGameIsOver() {
        return this.tennisScore.isOver();
    }

    public boolean hasNotAnnouncedTennisGameIsOver() {
        return this.tennisScore.isNotOver();
    }

}
