class TennisReferee {

    private TennisGameScore tennisGameScore;

    TennisReferee() {
        this.tennisGameScore = new TennisGameScore();
    }

    void addPointPlayer(int winnerPoint) {
        if (isPlayerOneWinPoint(winnerPoint)) {
            this.tennisGameScore.addPointPlayerOne();
        } else {
            this.tennisGameScore.addPointPlayerTwo();
        }
    }

    void updateGameScoreTable() {
        if (hasAnnouncedTennisGameIsOver()) {
            this.tennisGameScore.addGameOverCol();
        } else {
            this.tennisGameScore.addPointCol();
        }
    }

    void displayGameScoreTable() {
        this.tennisGameScore.displayGameScoreTable();
    }

    boolean isPlayerOneWinPoint(int winnerPoint) {
        return winnerPoint % 2 != 0;
    }

    boolean hasAnnouncedTennisGameIsOver() {
        return this.tennisGameScore.isOver();
    }

    boolean hasNotAnnouncedTennisGameIsOver() {
        return this.tennisGameScore.isNotOver();
    }

}
