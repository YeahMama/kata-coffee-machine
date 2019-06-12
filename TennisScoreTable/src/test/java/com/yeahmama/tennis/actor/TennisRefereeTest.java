package com.yeahmama.tennis.actor;

import com.yeahmama.tennis.score.TennisScore;
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
    private TennisScore tennisScore;

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
        doNothing().when(tennisScore).addPointPlayerOne();
        when(tennisScore.getPlayerOneScore()).thenReturn(1);

        // Act
        tennisReferee.updatePlayerPoints(PLAYER_ONE);

        // Assert
        assertThat(tennisScore.getPlayerOneScore()).isEqualTo(1);
    }

    @Test
    public void should_add_point_to_player_two_when_he_is_winner_point() {
        // Arrange
        doNothing().when(tennisScore).addPointPlayerTwo();
        when(tennisScore.getPlayerTwoScore()).thenReturn(1);

        // Act
        tennisReferee.updatePlayerPoints(PLAYER_TWO);

        // Assert
        assertThat(tennisScore.getPlayerTwoScore()).isEqualTo(1);
    }

    @Test
    public void should_display_game_score_only_once() {
        // Act
        tennisReferee.displayGameScore();

        // Assert
        verify(tennisScore, times(1)).displayScoreTable();
    }

    @Test
    public void should_announce_tennis_game_is_over_only_once() {
        // Act
        tennisReferee.hasAnnouncedTennisGameIsOver();

        // Assert
        verify(tennisScore, times(1)).isOver();
    }

    @Test
    public void should_announce_tennis_game_is_not_over_only_once() {
        // Act
        tennisReferee.hasNotAnnouncedTennisGameIsOver();

        // Assert
        verify(tennisScore, times(1)).isNotOver();

    }

}
