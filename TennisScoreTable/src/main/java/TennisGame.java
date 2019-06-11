class TennisGame {

    private TennisReferee tennisReferee;

    TennisGame() {
        this.tennisReferee = new TennisReferee();
    }

    void play() {
        System.out.println("Game score");

        while (this.tennisReferee.hasNotAnnoucedTennisGameIsOver()) {
            this.tennisReferee.addPointPlayer(getRandPlayResult());
            this.tennisReferee.updateGameScore();
        }

        this.tennisReferee.displayGameScore();
    }

    int getRandPlayResult() {
        return (int) Math.floor(Math.random() * 1001);
    }

}
