class TennisReferee {

    private TennisGameScore tennisGameScore;

    TennisReferee() {
        this.tennisGameScore = new TennisGameScore();
    }

    void addPointPlayer(int playResult) {
        if (isFedererWinPoint(playResult)) {
            this.tennisGameScore.addPointFederer();
        } else {
            this.tennisGameScore.addPointNadal();
        }
    }

    void updateGameScore() {
        if (hasAnnouncedTennisGameIsOver()) {
            this.tennisGameScore.addGameOverCol();
        } else {
            this.tennisGameScore.addPointCol();
        }
    }

    void displayGameScore() {
        this.tennisGameScore.displayGameScore();
    }

    boolean hasAnnouncedTennisGameIsOver() {
        return this.tennisGameScore.isOver();
    }

    boolean hasNotAnnoucedTennisGameIsOver() {
        return this.tennisGameScore.isNotOver();
    }

    boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

}
