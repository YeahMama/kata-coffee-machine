import java.util.ArrayList;
import java.util.Arrays;

class TennisGameScore {

    private int federerScore;
    private int nadalScore;

    private String winner;

    private ArrayList<String> gameScoreHeader;
    private ArrayList<String> gameScoreFedererRow;
    private ArrayList<String> gameScoreNadalRow;
    private ArrayList<String> gameScoreWinnerRow;

    TennisGameScore() {
        this.federerScore = 0;
        this.nadalScore = 0;

        this.gameScoreHeader = new ArrayList<>();
        this.gameScoreFedererRow = new ArrayList<>();
        this.gameScoreNadalRow = new ArrayList<>();
        this.gameScoreWinnerRow = new ArrayList<>();

        this.gameScoreHeader.add("");
        this.gameScoreHeader.add("Start the game");

        this.gameScoreFedererRow.add("Federer");
        this.gameScoreFedererRow.add("0");

        this.gameScoreNadalRow.add("Nadal");
        this.gameScoreNadalRow.add("0");

        this.gameScoreWinnerRow.add("");
        this.gameScoreWinnerRow.add("");
    }

    void addGameOverCol() {
        this.addWinnerPoint();
        this.gameScoreFedererRow.add("0");
        this.gameScoreNadalRow.add("0");
        this.gameScoreWinnerRow.add(this.winner + " wins the game");
    }

    void addPointCol() {
        this.addWinnerPoint();
        this.gameScoreFedererRow.add(toTennisScore(this.federerScore));
        this.gameScoreNadalRow.add(toTennisScore(this.nadalScore));
        this.gameScoreWinnerRow.add("");
    }

    private void addWinnerPoint() {
        this.gameScoreHeader.add(this.winner + " wins 1 point");
    }

    String toTennisScore(int score) {
        switch(score) {
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
        }

        return "0";
    }

     void displayGameScore() {
        TennisGameTable tennisGameTable = new TennisGameTable();

        tennisGameTable.setShowVerticalLines(true);
        tennisGameTable.setHeaders(toArrayString(this.gameScoreHeader));
        tennisGameTable.addRow(toArrayString(this.gameScoreFedererRow));
        tennisGameTable.addRow(toArrayString(this.gameScoreNadalRow));
        tennisGameTable.addRow(toArrayString(this.gameScoreWinnerRow));

        tennisGameTable.print();
    }

    String[] toArrayString(ArrayList<String> arrayList) {
        return Arrays.copyOf(arrayList.toArray(), arrayList.toArray().length, String[].class);
    }

    void addPointFederer() {
        this.federerScore += 1;
        this.winner = "Federer";
    }

    void addPointNadal() {
        this.nadalScore += 1;
        this.winner = "Nadal";
    }

    boolean isOver() {
        return this.federerScore == 4 || this.nadalScore == 4;
    }

    boolean isNotOver() {
        return (! isOver());
    }

    int getFedererScore() {
        return federerScore;
    }

    void setFedererScore(int federerScore) {
        this.federerScore = federerScore;
    }

    int getNadalScore() {
        return nadalScore;
    }

    void setNadalScore(int nadalScore) {
        this.nadalScore = nadalScore;
    }

    String getWinner() {
        return winner;
    }

    ArrayList<String> getGameScoreHeader() {
        return gameScoreHeader;
    }

    ArrayList<String> getGameScoreFedererRow() {
        return gameScoreFedererRow;
    }

    ArrayList<String> getGameScoreNadalRow() {
        return gameScoreNadalRow;
    }

    ArrayList<String> getGameScoreWinnerRow() {
        return gameScoreWinnerRow;
    }

}