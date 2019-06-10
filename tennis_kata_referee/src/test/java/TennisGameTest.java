import org.junit.Before;
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

    @Before
    public void setUp() {
        initTennisGameScore();
    }

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
    public void should_game_over_when_federer_wins_the_game() {
        // Arrange
        tennisGame.setFedererScore(4);

        // Act
        boolean tennisGameOver = tennisGame.isTennisGameOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_game_over_when_nadal_wins_the_game() {
        // Arrange
        tennisGame.setNadalScore(4);

        // Act
        boolean tennisGameOver = tennisGame.isTennisGameOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    private void initTennisGameScore() {
        tennisGameScore.init();
        tennisGameScore.addPoint(0, 1, "Nadal");
        tennisGameScore.addPoint(0, 2, "Nadal");
        tennisGameScore.addPoint(0, 3, "Nadal");
        tennisGameScore.addPoint(0, 4, "Nadal");
    }

}
