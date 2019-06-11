class TennisGame {

    private TennisGameScore tennisGameScore;

    TennisGame() {
        this.tennisGameScore = new TennisGameScore();
    }

    void play() {
        System.out.println("Game score");

        while (this.tennisGameScore.isNotOver()) {
            addPointPlayer(getRandPlayResult());
            updateGameScore();
        }

        this.tennisGameScore.displayGameScore();
    }

    void addPointPlayer(int playResult) {
        if (isFedererWinPoint(playResult)) {
            this.tennisGameScore.addPointFederer();
        } else {
            this.tennisGameScore.addPointNadal();
        }
    }

    void updateGameScore() {
        if (this.tennisGameScore.isOver()) {
            this.tennisGameScore.addGameOverCol();
        } else {
            this.tennisGameScore.addPointCol();
        }
    }


    int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

}
