package com.yeahmama.tennis.score;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TennisScoreTest {

    @InjectMocks
    private TennisScore tennisScore;

    @Mock
    private TennisScoreTable tennisScoreTable;

    @Test
    public void should_game_over_when_player_one_wins_the_game() {
        // Arrange
        tennisScore.setPlayerOneScore(4);

        // Act
        boolean tennisGameOver = tennisScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_game_over_when_player_two_wins_the_game() {
        // Arrange
        tennisScore.setPlayerTwoScore(4);

        // Act
        boolean tennisGameOver = tennisScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_not_game_over_when_no_one_wins() {
        // Arrange
        tennisScore.setPlayerOneScore(2);
        tennisScore.setPlayerTwoScore(2);

        // Act
        boolean tennisGameNotOver = tennisScore.isNotOver();

        // Assert
        assertThat(tennisGameNotOver).isTrue();
    }

    @Test
    public void should_add_point_to_player_one_when_he_wins_point() {
        // Act
        tennisScore.addPointPlayerOne();

        // Assert
        assertThat(tennisScore.getPlayerOneScore()).isEqualTo(1);
    }

    @Test
    public void should_add_point_to_player_two_when_he_wins_point() {
        // Act
        tennisScore.addPointPlayerTwo();

        // Assert
        assertThat(tennisScore.getPlayerTwoScore()).isEqualTo(1);
    }

    @Test
    public void should_add_game_over_column_to_game_score_table_when_it_has_a_game_winner() {
        // Arrange
        tennisScore.addPointPlayerOne();
        tennisScore.addPointPlayerOne();
        tennisScore.addPointPlayerOne();

        // Act
        tennisScore.addPointPlayerOne();

        // Assert
        verify(tennisScoreTable, times(1)).addGameOverCol(anyString());
    }

    @Test
    public void should_add_point_column_to_game_score_table_when_it_has_a_point_winner() {
        // Act
        tennisScore.addPointPlayerOne();

        // Assert
        verify(tennisScoreTable, times(1)).addPointCol(anyString(), anyInt(), anyInt());
    }

    @Test
    public void should_display_game_score_table_only_once() {
        // Act
        tennisScore.displayScoreTable();

        // Assert
        verify(tennisScoreTable, times(1)).display();
    }

}
