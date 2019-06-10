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
        assertThat(tennisGame.isFedererWinPoint(2)).isTrue();
    }

    private void initTennisGameScore() {
        tennisGameScore.init();
        tennisGameScore.addPoint(0, 1, "Nadal");
        tennisGameScore.addPoint(0, 2, "Nadal");
        tennisGameScore.addPoint(0, 3, "Nadal");
        tennisGameScore.addPoint(0, 4, "Nadal");
    }

}
