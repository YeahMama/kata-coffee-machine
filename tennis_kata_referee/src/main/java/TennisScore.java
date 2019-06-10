public class TennisScore {

    private String federerScore;
    private String nadalScore;
    private String winnerPoint;

    TennisScore(String federerScore, String nadalScore, String winnerPoint) {
        this.federerScore = federerScore;
        this.nadalScore = nadalScore;
        this.winnerPoint = winnerPoint;
    }

    @Override
    public String toString() {
        return this.federerScore + " - " + nadalScore + ": " + winnerPoint;
    }
}
