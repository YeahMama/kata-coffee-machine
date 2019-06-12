import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @InjectMocks
    private TennisGame tennisGame;

    @Mock
    private TennisReferee tennisReferee;

    @Mock
    private TennisPlayer tennisPlayerOne;

    @Mock
    private TennisPlayer tennisPlayerTwo;

    @Test
    public void should_finish_tennis_game_when_it_is_over() {
        // Arrange
        when(tennisReferee.hasNotAnnoucedTennisGameIsOver()).thenReturn(false);
        doNothing().when(tennisReferee).displayGameScore();

        // Act
        tennisGame.play();
    }

    @Test
    public void should_player_one_wins_the_point_when_he_has_better_hit_than_player_two() {
        // Arrange
        when(tennisPlayerOne.hit()).thenReturn(1);
        when(tennisPlayerTwo.hit()).thenReturn(0);

        // Act
        int winnerPoint = tennisGame.winnerPoint();

        // Assert
        assertThat(winnerPoint).isEqualTo(1);
    }

    @Test
    public void should_player_two_wins_the_point_when_he_has_better_hit_than_player_one() {
        // Arrange
        when(tennisPlayerOne.hit()).thenReturn(0);
        when(tennisPlayerTwo.hit()).thenReturn(1);

        // Act
        int winnerPoint = tennisGame.winnerPoint();

        // Assert
        assertThat(winnerPoint).isEqualTo(2);
    }

}
