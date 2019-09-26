package domain;

import org.apache.commons.lang3.StringUtils;
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
        // Arrange
        Drink tea = Drink.TEA;
        int nbOfSugars = 1;

        // Act
        String drink = drinkTranslator.toDrinkMaker(tea, nbOfSugars);

        // Assert
        assertThat(drink).isEqualTo("Th:1:0");
    }

    @Test
    public void should_have_correct_instruction_for_chocolate_without_sugar() {
        // Arrange
        Drink chocolate = Drink.CHOCOLATE;
        int nbOfSugars = 0;

        // Act
        String drink = drinkTranslator.toDrinkMaker(chocolate, nbOfSugars);

        // Assert
        assertThat(drink).isEqualTo("Hh::");
    }

    @Test
    public void should_have_correct_instruction_for_coffee_with_sugars() {
        // Arrange
        Drink coffee = Drink.COFFEE;
        int nbOfSugars = 2;

        // Act
        String drink = drinkTranslator.toDrinkMaker(coffee, nbOfSugars);

        // Assert
        assertThat(drink).isEqualTo("Ch:2:0");
    }

    @Test
    public void should_have_correct_instruction_for_orange_juice() {
        // Arrange
        Drink orange = Drink.ORANGE;
        int nbOfSugars = 0;

        // Act
        String drink = drinkTranslator.toDrinkMaker(orange, nbOfSugars);

        // Assert
        assertThat(drink).isEqualTo("O::");
    }

    @Test
    public void should_show_message_to_customer() {
        // Arrange
        String instructionsFromDrinkMaker = "M:This is what you ordered";

        // Act
        String message = drinkTranslator.toCustomer(instructionsFromDrinkMaker);

        // Assert
        assertThat(message).isEqualTo("This is what you ordered");
    }

    @Test
    public void should_not_show_message_when_instruction_has_no_message_code() {
        // Arrange
        String instructionsFromDrinkMaker = "E::";

        // Act
        String message = drinkTranslator.toCustomer(instructionsFromDrinkMaker);

        // Assert
        assertThat(message).isEqualTo(StringUtils.EMPTY);
    }

    @After
    public void tearDown() {
        drinkTranslator = null;
    }
}
