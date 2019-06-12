package com.yeahmama.tennis.actor;

public class TennisPlayer {

    private static final int MAX_HIT = 1001;

    public int hit() {
        return (int) Math.floor(Math.random() * MAX_HIT);
    }

}
