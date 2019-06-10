import java.util.ArrayList;

class TennisGame {

    private int federerScore;
    private int nadalScore;

    private ArrayList<TennisScore> gameScore;

    TennisGame() {
        this.federerScore = 0;
        this.nadalScore = 0;
        this.gameScore = new ArrayList<>();
    }

    void play() {
        System.out.println("Match : Federer - Nadal");
        gameScore.add(new TennisScore("0", "0", "Start the game"));

        int playResult;
        String winner = "No winner";

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
                gameScore.add(new TennisScore("0", "0", winner));
            } else {
                gameScore.add(new TennisScore(convertToTennisScore(this.federerScore), convertToTennisScore(this.nadalScore), winner));
            }

        }

        displayGameScore();
        System.out.println(winner + " win the game");
    }

    private void displayGameScore() {
        System.out.println(this.gameScore.toString());
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

    private String convertToTennisScore(int score) {
        switch(score) {
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
        }

        return "0";
    }

}
