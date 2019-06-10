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

            if (isTennisGameOver()) {
                this.tennisGameScore.addGameOver(winner);
            } else {
                this.tennisGameScore.addPoint(this.federerScore, this.nadalScore, winner);
            }
        }

        this.tennisGameScore.displayGameScore();
    }

    private int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

    boolean isTennisGameOver() {
        return this.federerScore == 4 || this.nadalScore == 4;
    }

    public int getFedererScore() {
        return federerScore;
    }

    public void setFedererScore(int federerScore) {
        this.federerScore = federerScore;
    }

    public int getNadalScore() {
        return nadalScore;
    }

    public void setNadalScore(int nadalScore) {
        this.nadalScore = nadalScore;
    }
}
