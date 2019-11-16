package com.yeahmama.kata.coffeemachine.domain;

import com.yeahmama.kata.coffeemachine.infrastructure.DrinkMakerProtocol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrinkOrderTest {

    @Mock
    private DrinkMakerProtocol drinkMakerProtocol;

    @InjectMocks
    private DrinkOrder drinkOrder;

    @Test
    public void should_forward_message_when_it_does_not_have_enough_money_for_a_drink() {
        // Arrange
        Drink chocolate = Drink.CHOCOLATE;
        int oneSugar = 1;
        double amount = 0.3;

        // Act
        drinkOrder.orderDrink(chocolate, oneSugar, amount);

        // Assert
        verify(drinkMakerProtocol, times(1)).forwardMessage(anyString());
    }

    @Test
    public void should_order_drink_only_when_it_has_drink_without_sugar() {
        // Arrange
        Drink coffee = Drink.COFFEE;
        int noSugar = 0;
        double amount = 0.7;

        // Act
        drinkOrder.orderDrink(coffee, noSugar, amount);

        // Assert
        verify(drinkMakerProtocol, times(1)).orderDrink(any(Drink.class));
    }

    @Test
    public void should_order_drink_with_sugar_when_it_has_drink_with_sugar() {
        // Arrange
        Drink tea = Drink.TEA;
        int twoSugars = 2;
        double amount = 0.7;

        // Act
        drinkOrder.orderDrink(tea, twoSugars, amount);

        // Assert
        verify(drinkMakerProtocol, times(1)).orderDrinkWithSugar(any(Drink.class), anyInt());
    }

}
