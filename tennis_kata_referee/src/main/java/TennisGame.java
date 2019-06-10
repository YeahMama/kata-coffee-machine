import java.util.ArrayList;
import java.util.Arrays;

class TennisGame {

    private int federerScore;
    private int nadalScore;

    private ArrayList<String> gameScoreHeader;
    private ArrayList<String> gameScoreFedererRow;
    private ArrayList<String> gameScoreNadalRow;
    private ArrayList<String> gameScoreWinnerRow;

    TennisGame() {
        this.federerScore = 0;
        this.nadalScore = 0;

        this.gameScoreHeader = new ArrayList<>();
        this.gameScoreFedererRow = new ArrayList<>();
        this.gameScoreNadalRow = new ArrayList<>();
        this.gameScoreWinnerRow = new ArrayList<>();
    }

    void play() {
        System.out.println("Game score");

        this.gameScoreHeader.add("");
        this.gameScoreHeader.add("Start the game");

        this.gameScoreFedererRow.add("Federer");
        this.gameScoreFedererRow.add("0");

        this.gameScoreNadalRow.add("Nadal");
        this.gameScoreNadalRow.add("0");

        this.gameScoreWinnerRow.add("");
        this.gameScoreWinnerRow.add("");

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

            this.gameScoreHeader.add(winner + " wins 1 point");

            if (isTennisGameOver()) {
                this.gameScoreFedererRow.add("0");
                this.gameScoreNadalRow.add("0");
                this.gameScoreWinnerRow.add(winner + " wins the game");
            } else {
                this.gameScoreFedererRow.add(convertToTennisScore(this.federerScore));
                this.gameScoreNadalRow.add(convertToTennisScore(this.nadalScore));
                this.gameScoreWinnerRow.add("");
            }

        }

        displayGameScore();
    }

    private void displayGameScore() {
        TennisGameTable st = new TennisGameTable();

        //st.setRightAlign(true);//if true then cell text is right aligned

        String[] str = Arrays.copyOf(this.gameScoreHeader.toArray(), this.gameScoreHeader.toArray().length, String[].class);
        String[] str2 = Arrays.copyOf(this.gameScoreFedererRow.toArray(), this.gameScoreFedererRow.toArray().length, String[].class);
        String[] str3 = Arrays.copyOf(this.gameScoreNadalRow.toArray(), this.gameScoreNadalRow.toArray().length, String[].class);
        String[] str4 = Arrays.copyOf(this.gameScoreWinnerRow.toArray(), this.gameScoreWinnerRow.toArray().length, String[].class);

        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders(str);//optional - if not used then there will be no header and horizontal lines
        st.addRow(str2);
        st.addRow(str3);
        st.addRow(str4);

        st.print();
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
