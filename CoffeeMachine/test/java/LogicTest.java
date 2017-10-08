import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LogicTest {
    @Test
    public void should_have_correct_instruction_for_tea_with_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Tea, 1))
                .isEqualTo(Drink.Tea.getCode() + ":1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Chocolate, 0))
                .isEqualTo(Drink.Chocolate.getCode() + "::");
    }

    @Test
    public void should_have_correct_instruction_for_coffee_with_sugars() throws Exception {
        Assertions.assertThat(new Logic().parseToDrinkMakerProtocol(Drink.Coffee, 2))
                .isEqualTo(Drink.Coffee.getCode() + ":2:0");
    }

    @Test
    public void should_have_correct_message_for_customer_to_see() throws Exception {
        Assertions.assertThat(new Logic().parseToCustomer("M:This is what you ordered"))
        .isEqualTo("This is what you ordered");
    }

    @Test
    public void should_make_drink_when_enough_money_is_given() throws Exception {
        Assertions.assertThat(new Logic().makeDrink(Drink.Tea, 2, 0.4))
                .contains(Drink.Tea.getCode() + ":2:0");
    }
}