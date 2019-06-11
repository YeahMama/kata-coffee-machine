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
        tennisGameScore.setFedererScore(4);

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_game_over_when_nadal_wins_the_game() {
        // Arrange
        tennisGameScore.setNadalScore(4);

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_not_game_over_when_no_one_wins() {
        // Arrange
        tennisGameScore.setFedererScore(2);
        tennisGameScore.setNadalScore(2);

        // Act
        boolean tennisGameNotOver = tennisGameScore.isNotOver();

        // Assert
        assertThat(tennisGameNotOver).isTrue();
    }

    @Test
    public void should_add_point_to_federer_when_federer_wins_point() {
        // Act
        tennisGameScore.addPointFederer();

        // Assert
        assertThat(tennisGameScore.getFedererScore()).isEqualTo(1);
        assertThat(tennisGameScore.getWinner()).isEqualTo("Federer");
    }

    @Test
    public void should_add_point_to_nadal_when_nadal_wins_point() {
        // Act
        tennisGameScore.addPointNadal();

        // Assert
        assertThat(tennisGameScore.getWinner()).isEqualTo("Nadal");
        assertThat(tennisGameScore.getNadalScore()).isEqualTo(1);
    }

    @Test
    public void should_give_0_as_tennis_score_when_score_is_0() {
        // Arrange
        int score = 0;

        // Act
        String tennisScore = tennisGameScore.toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("0");
    }

    @Test
    public void should_give_15_as_tennis_score_when_score_is_1() {
        // Arrange
        int score = 1;

        // Act
        String tennisScore = tennisGameScore.toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("15");
    }

    @Test
    public void should_give_30_as_tennis_score_when_score_is_2() {
        // Arrange
        int score = 2;

        // Act
        String tennisScore = tennisGameScore.toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("30");
    }

    @Test
    public void should_give_40_as_tennis_score_when_score_is_3() {
        // Arrange
        int score = 3;

        // Act
        String tennisScore = tennisGameScore.toTennisScore(score);

        // Assert
        assertThat(tennisScore).isEqualTo("40");
    }

}
