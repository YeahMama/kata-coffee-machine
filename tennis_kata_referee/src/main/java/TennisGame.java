class TennisGame {

    private static final String FEDERER_PLAYER = "Federer";
    private static final String NADAL_PLAYER = "Nadal";

    private int federerScore;
    private int nadalScore;

    TennisGame() {
        this.federerScore = 0;
        this.nadalScore = 0;
    }

    String play() {
        System.out.println("Match : Federer - Nadal");

        int playResult;
        while (this.federerScore != 4 && this.nadalScore != 4) {
            playResult = getRandPlayResult();

            if (isFedererWinPoint(playResult)) {
                this.federerScore += 1;
            } else {
                this.nadalScore += 1;
            }

            if (this.federerScore == 4 || this.nadalScore == 4) {
                System.out.println("Game set");
            } else {
                System.out.println(convertToTennisScore(this.federerScore) + " - " + convertToTennisScore(this.nadalScore));
            }

        }

        return isFedererWinGame()
                ? FEDERER_PLAYER
                : NADAL_PLAYER;
    }

    private int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

    private boolean isFedererWinPoint(int randResult) {
        return randResult % 2 == 0;
    }

    private boolean isFedererWinGame() {
        return this.federerScore == 4;
    }

    private String convertToTennisScore(int score) {
        switch(score) {
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
        }

        return "0";
    }

}
