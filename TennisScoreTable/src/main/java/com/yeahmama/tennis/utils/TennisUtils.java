package com.yeahmama.tennis.utils;

public class TennisUtils {

    public static String toTennisScore(int score) {
        switch (score) {
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
        }

        return "0";
    }

}
