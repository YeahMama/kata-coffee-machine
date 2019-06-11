import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @InjectMocks
    private TennisGame tennisGame;

    @Mock
    private TennisReferee tennisReferee;

    @Test
    public void should_give_random_play_result_when_it_gives_random_number_between_0_and_1000() {
        // Act
        int randPlayResult = tennisGame.getRandPlayResult();

        // Assert
        assertThat(randPlayResult).isBetween(0, 1000);
    }

    @Test
    public void should_finish_tennis_game_when_it_is_over() {
        // Arrange
        Mockito.when(tennisReferee.hasNotAnnoucedTennisGameIsOver()).thenReturn(false);
        Mockito.doNothing().when(tennisReferee).displayGameScore();

        // Act
        tennisGame.play();
    }

}
