package com.yeahmama.tennis.actor;

import com.yeahmama.tennis.score.TennisGameScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeTest {

    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;

    @InjectMocks
    private TennisReferee tennisReferee;

    @Mock
    private TennisGameScore tennisGameScore;

    @Test
    public void should_player_one_wins_one_point_when_it_has_an_odd_number() {
        // Act
        boolean playerOneWinsPoint = tennisReferee.isPlayerOneWinPoint(PLAYER_ONE);

        // Assert
        assertThat(playerOneWinsPoint).isTrue();
    }

    @Test
    public void should_player_two_wins_point_when_it_has_an_even_number() {
        // Act
        boolean playerTwoWinsPoint = tennisReferee.isPlayerOneWinPoint(PLAYER_TWO);

        // Assert
        assertThat(playerTwoWinsPoint).isFalse();
    }

    @Test
    public void should_add_point_to_player_one_when_he_is_winner_point() {
        // Arrange
        doNothing().when(tennisGameScore).addPointPlayerOne();
        when(tennisGameScore.getPlayerOneScore()).thenReturn(1);

        // Act
        tennisReferee.addPointPlayer(PLAYER_ONE);

        // Assert
        assertThat(tennisGameScore.getPlayerOneScore()).isEqualTo(1);
    }

    @Test
    public void should_add_point_to_player_two_when_he_is_winner_point() {
        // Arrange
        doNothing().when(tennisGameScore).addPointPlayerTwo();
        when(tennisGameScore.getPlayerTwoScore()).thenReturn(1);

        // Act
        tennisReferee.addPointPlayer(PLAYER_TWO);

        // Assert
        assertThat(tennisGameScore.getPlayerTwoScore()).isEqualTo(1);
    }

    @Test
    public void should_add_game_over_column_to_game_score_table_when_tennis_game_is_over() {
        // Arrange
        when(tennisGameScore.isOver()).thenReturn(true);

        // Act
        tennisReferee.updateGameScoreTable();

        // Assert
        verify(tennisGameScore, times(1)).addGameOverCol();
    }

    @Test
    public void should_add_point_column_to_game_score_table_when_a_player_wins_a_point() {
        // Arrange
        when(tennisGameScore.isOver()).thenReturn(false);

        // Act
        tennisReferee.updateGameScoreTable();

        // Assert
        verify(tennisGameScore, times(1)).addPointCol();
    }

    @Test
    public void should_display_game_score_only_once() {
        // Act
        tennisReferee.displayGameScoreTable();

        // Assert
        verify(tennisGameScore, times(1)).display();
    }

    @Test
    public void should_announce_tennis_game_is_over_only_once() {
        // Act
        tennisReferee.hasAnnouncedTennisGameIsOver();

        // Assert
        verify(tennisGameScore, times(1)).isOver();
    }

    @Test
    public void should_announce_tennis_game_is_not_over_only_once() {
        // Act
        tennisReferee.hasNotAnnouncedTennisGameIsOver();

        // Assert
        verify(tennisGameScore, times(1)).isNotOver();

    }

}
