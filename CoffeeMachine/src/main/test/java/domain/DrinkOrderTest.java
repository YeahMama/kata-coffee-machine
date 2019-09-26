package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrinkOrderTest {

    private DrinkOrder drinkOrder;

    @Before
    public void setUp() {
        drinkOrder = new DrinkOrder();
    }

    @Test
    public void should_make_drink_when_enough_money_is_given() {
        // Arrange
        Drink tea = Drink.TEA;
        int nbOfSugars = 2;
        double amount = 0.4;

        // Act
        String drink = drinkOrder.makeDrink(tea, nbOfSugars, amount);

        // Assert
        assertThat(drink).contains("Th:2:0");
    }

    @Test
    public void should_not_make_drink_when_not_enough_money_is_given() {
        // Arrange
        Drink coffee = Drink.COFFEE;
        int nbOfSugars = 0;
        double amount = 0.2;

        // Act
        String drink = drinkOrder.makeDrink(coffee, nbOfSugars, amount);

        // Assert
        assertThat(drink).contains("Need " + (Drink.COFFEE.getPrice() - 0.2));
    }

    @After
    public void tearDown() {
        drinkOrder = null;
    }
}
