import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LogicTest {
    @Test
    public void should_have_correct_instruction_for_tea_with_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Tea.name(), 1))
                .isEqualTo(Drink.Tea.getCode() + ":1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Chocolate.name(), 0))
                .isEqualTo(Drink.Chocolate.getCode() + "::");
    }

    @Test
    public void should_have_correct_instruction_for_coffee_with_sugars() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Coffee.name(), 2))
                .isEqualTo(Drink.Coffee.getCode() + ":2:0");
    }
}