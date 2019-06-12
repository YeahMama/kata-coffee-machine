package com.yeahmama.tennis.score;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TennisScoreTableTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @InjectMocks
    private TennisScoreTable tennisScoreTable;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void should_add_game_over_column_to_game_score_table_when_a_player_wins_4_points() {
        // Arrange
        tennisScoreTable.addPointCol("Player 1", 1, 0);
        tennisScoreTable.addPointCol("Player 1", 2, 0);
        tennisScoreTable.addPointCol("Player 1", 3, 0);

        // Act
        tennisScoreTable.addGameOverCol("Player 1");

        // Assert
        assertThat(tennisScoreTable.getGameScoreHeader().get(4)).isEqualTo("Player 1 wins 1 point");
        assertThat(tennisScoreTable.getGameScorePlayerOneRow().get(4)).isEqualTo("0");
        assertThat(tennisScoreTable.getGameScorePlayerTwoRow().get(4)).isEqualTo("0");
        assertThat(tennisScoreTable.getGameScoreWinnerRow().get(4)).isEqualTo("Player 1 wins the game");
    }

    @Test
    public void should_add_point_column_to_game_score_table_when_it_has_a_point_winner() {
        // Act
        tennisScoreTable.addPointCol("Player 1", 1, 0);

        // Assert
        assertThat(tennisScoreTable.getGameScoreHeader().get(2)).isEqualTo("Player 1 wins 1 point");
        assertThat(tennisScoreTable.getGameScorePlayerOneRow().get(2)).isEqualTo("15");
        assertThat(tennisScoreTable.getGameScorePlayerTwoRow().get(2)).isEqualTo("0");
        assertThat(tennisScoreTable.getGameScoreWinnerRow().get(2)).isEqualTo("");
    }

    @Test
    public void should_have_tennis_game_score_table_initialized() {
        // Act
        tennisScoreTable.display();

        // Assert
        assertThat(displayGameScoreTableInit()).isEqualTo(outContent.toString());
    }

    private String displayGameScoreTableInit() {
        return "Game score\n" +
                "+----------+----------------+\n" +
                "|          | Start the game |\n" +
                "+----------+----------------+\n" +
                "| Player 1 | 0              |\n" +
                "| Player 2 | 0              |\n" +
                "|          |                |\n" +
                "+----------+----------------+\n";
    }

    @Test
    public void should_have_tennis_game_score_table_with_one_point_column_when_adding_one_point() {
        // Arrange
        tennisScoreTable.addPointCol("Player 1", 1, 0);

        // Act
        tennisScoreTable.display();

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
        tennisScoreTable.addPointCol("Player 1", 1, 0);
        tennisScoreTable.addPointCol("Player 1", 2, 0);
        tennisScoreTable.addPointCol("Player 1", 3, 0);
        tennisScoreTable.addGameOverCol("Player 1");

        // Act
        tennisScoreTable.display();

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
