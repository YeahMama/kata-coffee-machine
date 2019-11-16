package com.yeahmama.kata.coffeemachine.infrastructure;

import com.yeahmama.kata.coffeemachine.service.DrinkMaker;
import com.yeahmama.kata.coffeemachine.domain.Drink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrinkMakerProtocolTest {

    @InjectMocks
    private DrinkMakerProtocol drinkMakerProtocol;

    @Mock
    private DrinkMaker drinkMaker;

    @Test
    public void should_make_drink_when_it_has_drink_only() {
        // Given
        Drink chocolate = Drink.CHOCOLATE;

        // Act
        drinkMakerProtocol.orderDrink(chocolate);

        // Assert
        verify(drinkMaker, times(1)).makeDrink(anyString());
    }

    @Test
    public void should_make_drink_when_it_has_drink_with_sugars() {
        // Arrange
        Drink tea = Drink.TEA;
        int oneSugar = 1;

        // Act
        drinkMakerProtocol.orderDrinkWithSugar(tea, oneSugar);

        // Assert
        verify(drinkMaker, times(1)).makeDrink(anyString());
    }

    @Test
    public void should_forward_message_when_it_has_message() {
        // Arrange
        String message = "Need 0.1";

        // Act
        drinkMakerProtocol.forwardMessage(message);

        // Assert
        verify(drinkMaker, times(1)).forwardMessage(anyString());
    }

    @Test
    public void should_build_command_for_drink_only() {
        // Arrange
        Drink chocolate = Drink.CHOCOLATE;

        // Act
        String chocolateCommand = drinkMakerProtocol.buildDrinkCommand(chocolate);

        // Assert
        assertThat(chocolateCommand).isEqualTo("Hh::");
    }

    @Test
    public void should_build_command_for_drink_with_sugars() {
        // Arrange
        Drink tea = Drink.TEA;
        int twoSugars = 2;

        // Act
        String teaWithSugarsCommand = drinkMakerProtocol.buildDrinkWithSugarCommand(tea, twoSugars);

        // Assert
        assertThat(teaWithSugarsCommand).isEqualTo("Th:2:0");
    }

    @Test
    public void should_build_command_for_forwarding_message() {
        // Arrange
        String message = "Need 0.1";

        // Act
        String messageCommand = drinkMakerProtocol.buildMessageCommand(message);

        // Assert
        assertThat(messageCommand).isEqualTo("M:Need 0.1");
    }

}
