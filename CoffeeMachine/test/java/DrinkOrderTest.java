import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DrinkOrderTest {

    private DrinkOrder drinkOrder;

    @Before
    public void setUp() throws Exception {
        drinkOrder = new DrinkOrder();
    }

    @Test
    public void should_make_drink_when_enough_money_is_given() throws Exception {
        Assertions.assertThat(drinkOrder.makeDrink(Drink.Tea, 2, 0.4))
                .contains(Drink.Tea.getCode() + ":2:0");
    }

    @Test
    public void should_not_make_drink_when_not_enough_money_is_given() throws Exception {
        drinkOrder = new DrinkOrder();
        Assertions.assertThat(drinkOrder.makeDrink(Drink.Coffee, 0, 0.2))
                .contains("Need " + String.valueOf(Drink.Coffee.getPrice() - 0.2));
    }

    @After
    public void tearDown() throws Exception {
        drinkOrder = null;
    }
}