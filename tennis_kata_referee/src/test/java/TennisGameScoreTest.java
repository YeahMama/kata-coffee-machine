import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameScoreTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @InjectMocks
    private TennisGameScore tennisGameScore;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

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

    @Test
    public void should_add_game_column_to_game_score_table_when_it_has_a_game_winner() {
        // Arrange
        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();

        // Act
        tennisGameScore.addGameOverCol();

        // Assert
        assertThat(tennisGameScore.getGameScoreHeader().get(5)).isEqualTo("Federer wins 1 point");
        assertThat(tennisGameScore.getGameScoreFedererRow().get(5)).isEqualTo("0");
        assertThat(tennisGameScore.getGameScoreNadalRow().get(5)).isEqualTo("0");
        assertThat(tennisGameScore.getGameScoreWinnerRow().get(5)).isEqualTo("Federer wins the game");
    }

    @Test
    public void should_add_game_column_to_game_score_table_when_it_has_a_point_winner() {
        // Arrange
        tennisGameScore.addPointFederer();

        // Act
        tennisGameScore.addPointCol();

        // Assert
        assertThat(tennisGameScore.getGameScoreHeader().get(2)).isEqualTo("Federer wins 1 point");
        assertThat(tennisGameScore.getGameScoreFedererRow().get(2)).isEqualTo("15");
        assertThat(tennisGameScore.getGameScoreNadalRow().get(2)).isEqualTo("0");
        assertThat(tennisGameScore.getGameScoreWinnerRow().get(2)).isEqualTo("");
    }

    @Test
    public void should_convert_array_list_to_array_string() {
        // Arrange
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("Something");

        // Act
        String[] arrayString = tennisGameScore.toArrayString(arrayListString);

        // Assert
        assertThat(arrayListString.get(0)).isEqualTo(arrayString[0]);
    }

    @Test
    public void should_display_tennis_game_score_when_adding_one_point() {
        // Arrange
        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        // Act
        tennisGameScore.displayGameScore();

        // Assert
        assertThat(displayGameScoreTableForOnePoint()).isEqualTo(outContent.toString());
    }

    private String displayGameScoreTableForOnePoint() {
        return "+---------+----------------+----------------------+\n" +
                "|         | Start the game | Federer wins 1 point |\n" +
                "+---------+----------------+----------------------+\n" +
                "| Federer | 0              | 15                   |\n" +
                "| Nadal   | 0              | 0                    |\n" +
                "|         |                |                      |\n" +
                "+---------+----------------+----------------------+\n";
    }

    @Test
    public void should_display_tennis_game_score_when_adding_game_over_column_and_only_federer_wins_points() {
        // Arrange
        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointFederer();
        tennisGameScore.addGameOverCol();

        // Act
        tennisGameScore.displayGameScore();

        // Assert
        assertThat(display_game_score_table_for_four_points_of_federer_with_game_over_col()).isEqualTo(outContent.toString());
    }

    private String display_game_score_table_for_four_points_of_federer_with_game_over_col() {
        return "+---------+----------------+----------------------+----------------------+----------------------+-----------------------+\n" +
                "|         | Start the game | Federer wins 1 point | Federer wins 1 point | Federer wins 1 point | Federer wins 1 point  |\n" +
                "+---------+----------------+----------------------+----------------------+----------------------+-----------------------+\n" +
                "| Federer | 0              | 15                   | 30                   | 40                   | 0                     |\n" +
                "| Nadal   | 0              | 0                    | 0                    | 0                    | 0                     |\n" +
                "|         |                |                      |                      |                      | Federer wins the game |\n" +
                "+---------+----------------+----------------------+----------------------+----------------------+-----------------------+\n";
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}
