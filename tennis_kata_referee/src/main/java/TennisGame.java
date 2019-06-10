class TennisGame {

    private TennisGameScore tennisGameScore;

    TennisGame() {
        this.tennisGameScore = new TennisGameScore();
    }

    void play() {
        System.out.println("Game score");
        this.tennisGameScore.init();

        int playResult;

        while (!this.tennisGameScore.isTennisGameOver()) {
            playResult = getRandPlayResult();

            if (isFedererWinPoint(playResult)) {
                this.tennisGameScore.addPointFederer();
            } else {
                this.tennisGameScore.addPointNadal();
            }

            if (this.tennisGameScore.isTennisGameOver()) {
                this.tennisGameScore.addGameOver();
            } else {
                this.tennisGameScore.addPoint();
            }
        }

        this.tennisGameScore.displayGameScore();
    }

    int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

}
