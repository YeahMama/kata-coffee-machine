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

    @Test
    public void should_add_point_to_federer_when_federer_wins_one_point() {
        // Arrange
        Mockito.doNothing().when(tennisGameScore).addPointFederer();
        Mockito.when(tennisGameScore.getFedererScore()).thenReturn(1);

        // Act
        tennisGame.addPointPlayer(2);

        // Assert
        assertThat(tennisGameScore.getFedererScore()).isEqualTo(1);
    }

    @Test
    public void should_add_point_to_nadal_when_nadal_wins_one_point() {
        // Arrange
        Mockito.doNothing().when(tennisGameScore).addPointNadal();
        Mockito.when(tennisGameScore.getNadalScore()).thenReturn(1);

        // Act
        tennisGame.addPointPlayer(1);

        // Assert
        assertThat(tennisGameScore.getNadalScore()).isEqualTo(1);
    }

    @Test
    public void should_update_score_when_tennis_game_is_over() {
        // Arrange
        Mockito.when(tennisGameScore.isOver()).thenReturn(true);
        Mockito.doNothing().when(tennisGameScore).addGameOver();

        // Act
        tennisGame.updateGameScore();
    }

    @Test
    public void should_update_score_when_a_player_wins_point() {
        // Arrange
        Mockito.when(tennisGameScore.isOver()).thenReturn(false);
        Mockito.doNothing().when(tennisGameScore).addPoint();

        // Act
        tennisGame.updateGameScore();
    }

    @Test
    public void should_finish_tennis_game_when_it_is_over() {
        // Arrange
        Mockito.doNothing().when(tennisGameScore).init();
        Mockito.when(tennisGameScore.isNotOver()).thenReturn(false);
        Mockito.doNothing().when(tennisGameScore).displayGameScore();

        // Act
        tennisGame.play();
    }

}
