package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkTranslatorTest {
    private DrinkTranslator drinkTranslator;

    @Before
    public void setUp() {
        drinkTranslator = new DrinkTranslator();
    }

    @Test
    public void should_have_correct_instruction_for_tea_with_sugar() {
        assertThat(drinkTranslator.toDrinkMaker(Drink.TEA, 1)).isEqualTo(Drink.TEA.getCode() + ":1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() {
        assertThat(drinkTranslator.toDrinkMaker(Drink.CHOCOLATE, 0)).isEqualTo(Drink.CHOCOLATE.getCode() + "::");
    }

    @Test
    public void should_have_correct_instruction_for_coffee_with_sugars() {
        assertThat(drinkTranslator.toDrinkMaker(Drink.COFFEE, 2)).isEqualTo(Drink.COFFEE.getCode() + ":2:0");
    }

    @Test
    public void should_have_correct_instruction_for_orange_juice() {
        assertThat(drinkTranslator.toDrinkMaker(Drink.ORANGE, 0)).isEqualTo(Drink.ORANGE.getCode() + "::");
    }

    @Test
    public void should_have_correct_message_for_customer_to_see() {
        assertThat(drinkTranslator.toCustomer("M:This is what you ordered")).isEqualTo("This is what you ordered");
    }

    @Test
    public void should_have_no_message_when_instruction_has_no_message_code() {
        assertThat(drinkTranslator.toCustomer("E::")).isEqualTo("");
    }

    @After
    public void tearDown() {
        drinkTranslator = null;
    }
}