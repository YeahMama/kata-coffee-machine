package com.yeahmama.tennis.score;

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
    public void should_game_over_when_player_one_wins_the_game() {
        // Arrange
        tennisGameScore.setPlayerOneScore(4);

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_game_over_when_player_two_wins_the_game() {
        // Arrange
        tennisGameScore.setPlayerTwoScore(4);

        // Act
        boolean tennisGameOver = tennisGameScore.isOver();

        // Assert
        assertThat(tennisGameOver).isTrue();
    }

    @Test
    public void should_not_game_over_when_no_one_wins() {
        // Arrange
        tennisGameScore.setPlayerOneScore(2);
        tennisGameScore.setPlayerTwoScore(2);

        // Act
        boolean tennisGameNotOver = tennisGameScore.isNotOver();

        // Assert
        assertThat(tennisGameNotOver).isTrue();
    }

    @Test
    public void should_add_point_to_player_one_when_he_wins_point() {
        // Act
        tennisGameScore.addPointPlayerOne();

        // Assert
        assertThat(tennisGameScore.getPlayerOneScore()).isEqualTo(1);
        assertThat(tennisGameScore.getWinner()).isEqualTo("Player 1");
    }

    @Test
    public void should_add_point_to_player_two_when_he_wins_point() {
        // Act
        tennisGameScore.addPointPlayerTwo();

        // Assert
        assertThat(tennisGameScore.getPlayerTwoScore()).isEqualTo(1);
        assertThat(tennisGameScore.getWinner()).isEqualTo("Player 2");
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
    public void should_add_game_over_column_to_game_score_table_when_it_has_a_game_winner() {
        // Arrange
        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();

        // Act
        tennisGameScore.addGameOverCol();

        // Assert
        assertThat(tennisGameScore.getGameScoreHeader().get(5)).isEqualTo("Player 1 wins 1 point");
        assertThat(tennisGameScore.getGameScorePlayerOneRow().get(5)).isEqualTo("0");
        assertThat(tennisGameScore.getGameScorePlayerTwoRow().get(5)).isEqualTo("0");
        assertThat(tennisGameScore.getGameScoreWinnerRow().get(5)).isEqualTo("Player 1 wins the game");
    }

    @Test
    public void should_add_point_column_to_game_score_table_when_it_has_a_point_winner() {
        // Arrange
        tennisGameScore.addPointPlayerOne();

        // Act
        tennisGameScore.addPointCol();

        // Assert
        assertThat(tennisGameScore.getGameScoreHeader().get(2)).isEqualTo("Player 1 wins 1 point");
        assertThat(tennisGameScore.getGameScorePlayerOneRow().get(2)).isEqualTo("15");
        assertThat(tennisGameScore.getGameScorePlayerTwoRow().get(2)).isEqualTo("0");
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
    public void should_have_tennis_game_score_table_with_one_point_column_when_adding_one_point() {
        // Arrange
        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        // Act
        tennisGameScore.displayGameScoreTable();

        // Assert
        assertThat(displayGameScoreTableWithOnePoint()).isEqualTo(outContent.toString());
    }

    private String displayGameScoreTableWithOnePoint() {
        return "Game score\n" +
                "+----------+----------------+-----------------------+\n" +
                "|          | Start the game | Player 1 wins 1 point |\n" +
                "+----------+----------------+-----------------------+\n" +
                "| Player 1 | 0              | 15                    |\n" +
                "| Player 2 | 0              | 0                     |\n" +
                "|          |                |                       |\n" +
                "+----------+----------------+-----------------------+\n";
    }

    @Test
    public void should_have_final_tennis_game_score_table_when_adding_game_over_column() {
        // Arrange
        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addPointCol();

        tennisGameScore.addPointPlayerOne();
        tennisGameScore.addGameOverCol();

        // Act
        tennisGameScore.displayGameScoreTable();

        // Assert
        assertThat(displayFinalGameScoreTable()).isEqualTo(outContent.toString());
    }

    private String displayFinalGameScoreTable() {
        return "Game score\n" +
                "+----------+----------------+-----------------------+-----------------------+-----------------------+------------------------+\n" +
                "|          | Start the game | Player 1 wins 1 point | Player 1 wins 1 point | Player 1 wins 1 point | Player 1 wins 1 point  |\n" +
                "+----------+----------------+-----------------------+-----------------------+-----------------------+------------------------+\n" +
                "| Player 1 | 0              | 15                    | 30                    | 40                    | 0                      |\n" +
                "| Player 2 | 0              | 0                     | 0                     | 0                     | 0                      |\n" +
                "|          |                |                       |                       |                       | Player 1 wins the game |\n" +
                "+----------+----------------+-----------------------+-----------------------+-----------------------+------------------------+\n";
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}
