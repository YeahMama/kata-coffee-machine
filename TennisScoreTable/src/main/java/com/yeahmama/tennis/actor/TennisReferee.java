package com.yeahmama.tennis.actor;

import com.yeahmama.tennis.score.TennisGameScore;

public class TennisReferee {

    private TennisGameScore tennisGameScore;

    public TennisReferee() {
        this.tennisGameScore = new TennisGameScore();
    }

    public void addPointPlayer(int winnerPoint) {
        if (isPlayerOneWinPoint(winnerPoint)) {
            this.tennisGameScore.addPointPlayerOne();
        } else {
            this.tennisGameScore.addPointPlayerTwo();
        }
    }

    public void updateGameScoreTable() {
        if (hasAnnouncedTennisGameIsOver()) {
            this.tennisGameScore.addGameOverCol();
        } else {
            this.tennisGameScore.addPointCol();
        }
    }

    public void displayGameScoreTable() {
        this.tennisGameScore.displayGameScoreTable();
    }

    public boolean isPlayerOneWinPoint(int winnerPoint) {
        return winnerPoint % 2 != 0;
    }

    public boolean hasAnnouncedTennisGameIsOver() {
        return this.tennisGameScore.isOver();
    }

    public boolean hasNotAnnouncedTennisGameIsOver() {
        return this.tennisGameScore.isNotOver();
    }

}
