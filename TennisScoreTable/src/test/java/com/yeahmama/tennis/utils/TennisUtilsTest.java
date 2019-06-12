package com.yeahmama.tennis.utils;

import org.junit.Test;

import static com.yeahmama.tennis.utils.TennisUtils.toTennisScore;
import static org.assertj.core.api.Assertions.assertThat;

public class TennisUtilsTest {

    @Test
    public void should_give_0_as_tennis_score_when_score_is_0() {
        // Arrange
        int score = 0;

        // Act
        String tennisScore = toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("0");
    }

    @Test
    public void should_give_15_as_tennis_score_when_score_is_1() {
        // Arrange
        int score = 1;

        // Act
        String tennisScore = toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("15");
    }

    @Test
    public void should_give_30_as_tennis_score_when_score_is_2() {
        // Arrange
        int score = 2;

        // Act
        String tennisScore = toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("30");
    }

    @Test
    public void should_give_40_as_tennis_score_when_score_is_3() {
        // Arrange
        int score = 3;

        // Act
        String tennisScore = toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("40");
    }

}
