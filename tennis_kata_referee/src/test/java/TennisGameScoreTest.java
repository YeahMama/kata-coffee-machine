import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameScoreTest {

    @InjectMocks
    private TennisGameScore tennisGameScore;

    @Test
    public void should_game_over_when_federer_wins_the_game() {
        // Arrange
        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_game_over_when_nadal_wins_the_game() {
        // Arrange
        tennisGameScore.addPointNadal();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointNadal();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointNadal();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointNadal();
        tennisGameScore.addPointCol();

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

}
