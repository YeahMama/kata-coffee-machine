import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LogicTest {
    @Test
    public void should_have_correct_instruction_for_tea_with_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol("Tea", 1))
                .isEqualTo("T:1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol("Chocolate", 0))
                .isEqualTo("H::");
    }
}