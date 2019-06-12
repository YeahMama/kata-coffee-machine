package com.yeahmama.tennis;

import com.yeahmama.tennis.actor.TennisPlayer;
import com.yeahmama.tennis.actor.TennisReferee;

public class TennisGame {

    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;

    private TennisReferee tennisReferee;

    private TennisPlayer tennisPlayerOne;
    private TennisPlayer tennisPlayerTwo;

    TennisGame() {
        this.tennisReferee = new TennisReferee();

        this.tennisPlayerOne = new TennisPlayer();
        this.tennisPlayerTwo = new TennisPlayer();
    }

    public void play() {
        while (this.tennisReferee.hasNotAnnouncedTennisGameIsOver()) {
            int winnerPoint = winnerPoint();

            this.tennisReferee.addPointPlayer(winnerPoint);
            this.tennisReferee.updateGameScoreTable();
        }

        this.tennisReferee.displayGameScoreTable();
    }

    public int winnerPoint() {
        int tennisPlayerOneHit = -1;
        int tennisPlayerTwoHit = -1;

        while (tennisPlayerOneHit == tennisPlayerTwoHit) {
            tennisPlayerOneHit = this.tennisPlayerOne.hit();
            tennisPlayerTwoHit = this.tennisPlayerTwo.hit();
        }

        return tennisPlayerOneHit > tennisPlayerTwoHit
                ? PLAYER_ONE
                : PLAYER_TWO;
    }

}
