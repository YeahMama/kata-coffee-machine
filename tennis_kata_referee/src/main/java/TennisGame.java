class TennisGame {

    private TennisGameScore tennisGameScore;

    TennisGame() {
        this.tennisGameScore = new TennisGameScore();
    }

    void play() {
        System.out.println("Game score");
        this.tennisGameScore.init();

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
            this.tennisGameScore.addGameOver();
        } else {
            this.tennisGameScore.addPoint();
        }
    }


    int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

}
