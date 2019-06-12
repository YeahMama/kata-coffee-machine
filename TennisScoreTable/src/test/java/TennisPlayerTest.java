import com.yeahmama.tennis.actor.TennisPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisPlayerTest {

    @InjectMocks
    private TennisPlayer tennisPlayer;

    @Test
    public void should_have_tennis_player_hit_between_0_and_1000() {
        // Act
        int tennisPlayerHit = tennisPlayer.hit();

        // Assert
        assertThat(tennisPlayerHit).isBetween(0, 1000);
    }

}
