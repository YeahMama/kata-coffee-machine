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
        assertThat(drinkOrder.makeDrink(Drink.TEA, 2, 0.4)).contains(Drink.TEA.getCode() + ":2:0");
    }

    @Test
    public void should_not_make_drink_when_not_enough_money_is_given() {
        drinkOrder = new DrinkOrder();
        assertThat(drinkOrder.makeDrink(Drink.COFFEE, 0, 0.2)).contains("Need " + (Drink.COFFEE.getPrice() - 0.2));
    }

    @After
    public void tearDown() {
        drinkOrder = null;
    }
}