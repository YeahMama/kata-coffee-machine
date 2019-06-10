class TennisGame {

    private int federerScore;
    private int nadalScore;

    private TennisGameScore tennisGameScore;

    TennisGame() {
        this.federerScore = 0;
        this.nadalScore = 0;

        this.tennisGameScore = new TennisGameScore();
    }

    void play() {
        System.out.println("Game score");
        this.tennisGameScore.init();

        int playResult;
        String winner;

        while (! isTennisGameOver()) {
            playResult = getRandPlayResult();

            if (isFedererWinPoint(playResult)) {
                this.federerScore += 1;
                winner = "Federer";
            } else {
                this.nadalScore += 1;
                winner = "Nadal";
            }

            this.tennisGameScore.addWinnerPoint(winner);

            if (isTennisGameOver()) {
                this.tennisGameScore.addGameOver(winner);
            } else {
                this.tennisGameScore.addPoint(this.federerScore, this.nadalScore);
            }
        }

        this.tennisGameScore.displayGameScore();
    }

    private boolean isTennisGameOver() {
        return this.federerScore == 4 || this.nadalScore == 4;
    }

    private int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    private boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

}
