import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DrinkTranslatorTest {
    private DrinkTranslator drinkTranslator;

    @Before
    public void setUp() throws Exception {
        drinkTranslator = new DrinkTranslator();
    }

    @Test
    public void should_have_correct_instruction_for_tea_with_sugar() throws Exception {
        Assertions.assertThat(drinkTranslator.toDrinkMaker(Drink.Tea, 1))
                .isEqualTo(Drink.Tea.getCode() + ":1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() throws Exception {
        Assertions.assertThat(drinkTranslator.toDrinkMaker(Drink.Chocolate, 0))
                .isEqualTo(Drink.Chocolate.getCode() + "::");
    }

    @Test
    public void should_have_correct_instruction_for_coffee_with_sugars() throws Exception {
        Assertions.assertThat(drinkTranslator.toDrinkMaker(Drink.Coffee, 2))
                .isEqualTo(Drink.Coffee.getCode() + ":2:0");
    }

    @Test
    public void should_have_correct_instruction_for_orange_juice() throws Exception {
        Assertions.assertThat(drinkTranslator.toDrinkMaker(Drink.Orange, 0))
                .isEqualTo(Drink.Orange.getCode() + "::");
    }

    @Test
    public void should_have_correct_message_for_customer_to_see() throws Exception {
        Assertions.assertThat(drinkTranslator.toCustomer("M:This is what you ordered"))
                .isEqualTo("This is what you ordered");
    }

    @Test
    public void should_have_no_message_when_instruction_has_no_message_code() throws Exception {
        Assertions.assertThat(drinkTranslator.toCustomer("E::"))
                .isEqualTo("");
    }

    @After
    public void tearDown() throws Exception {
        drinkTranslator = null;
    }
}