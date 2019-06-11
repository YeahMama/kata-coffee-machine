import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeTest {

    @InjectMocks
    private TennisReferee tennisReferee;

    @Mock
    private TennisGameScore tennisGameScore;

    @Test
    public void should_federer_wins_point_when_it_has_an_even_number() {
        // Arrange
        int randResult = 2;

        // Act
        boolean federerWinPoint = tennisReferee.isFedererWinPoint(randResult);

        // Assert
        assertThat(federerWinPoint).isTrue();
    }

    @Test
    public void should_nadal_wins_point_when_it_has_an_odd_number() {
        // Arrange
        int randResult = 1;

        // Act
        boolean federerWinPoint = tennisReferee.isFedererWinPoint(randResult);

        // Assert
        assertThat(federerWinPoint).isFalse();
    }

    @Test
    public void should_add_point_to_federer_when_federer_wins_one_point() {
        // Arrange
        doNothing().when(tennisGameScore).addPointFederer();
        when(tennisGameScore.getFedererScore()).thenReturn(1);

        // Act
        tennisReferee.addPointPlayer(2);

        // Assert
        assertThat(tennisGameScore.getFedererScore()).isEqualTo(1);
    }

    @Test
    public void should_add_point_to_nadal_when_nadal_wins_one_point() {
        // Arrange
        doNothing().when(tennisGameScore).addPointNadal();
        when(tennisGameScore.getNadalScore()).thenReturn(1);

        // Act
        tennisReferee.addPointPlayer(1);

        // Assert
        assertThat(tennisGameScore.getNadalScore()).isEqualTo(1);
    }

    @Test
    public void should_update_score_when_tennis_game_is_over() {
        // Arrange
        when(tennisGameScore.isOver()).thenReturn(true);
        doNothing().when(tennisGameScore).addGameOverCol();

        // Act
        tennisReferee.updateGameScore();
    }

    @Test
    public void should_update_score_when_a_player_wins_point() {
        // Arrange
        when(tennisGameScore.isOver()).thenReturn(false);
        doNothing().when(tennisGameScore).addPointCol();

        // Act
        tennisReferee.updateGameScore();
    }

    @Test
    public void should_display_game_score_only_once() {
        // Act
        tennisReferee.displayGameScore();

        // Assert
        verify(tennisGameScore, times(1)).displayGameScore();
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
        tennisReferee.hasNotAnnoucedTennisGameIsOver();

        // Assert
        verify(tennisGameScore, times(1)).isNotOver();

    }

}
