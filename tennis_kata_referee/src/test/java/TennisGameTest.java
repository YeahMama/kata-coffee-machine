import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @InjectMocks
    private TennisGame tennisGame;

    @Mock
    private TennisGameScore tennisGameScore;

    @Test
    public void should_federer_wins_point_when_it_has_an_even_number() {
        // Arrange
        int randResult = 2;

        // Act
        boolean federerWinPoint = tennisGame.isFedererWinPoint(randResult);

        // Assert
        assertThat(federerWinPoint).isTrue();
    }

    @Test
    public void should_nadal_wins_point_when_it_has_an_odd_number() {
        // Arrange
        int randResult = 1;

        // Act
        boolean federerWinPoint = tennisGame.isFedererWinPoint(randResult);

        // Assert
        assertThat(federerWinPoint).isFalse();
    }

    @Test
    public void should_give_random_play_result_when_it_gives_random_number_between_0_and_1000() {
        // Act
        int randPlayResult = tennisGame.getRandPlayResult();

        // Assert
        assertThat(randPlayResult).isBetween(0, 1000);
    }

}
