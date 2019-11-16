package com.yeahmama.kata.coffeemachine.infrastructure;

import com.yeahmama.kata.coffeemachine.domain.Drink;
import com.yeahmama.kata.coffeemachine.service.DrinkMaker;

public class DrinkMakerProtocol {

    private static final String STICK_CODE = "0";
    private static final String MESSAGE_CODE = "M";
    private static final String COMMAND_SEPARATOR = ":";

    private DrinkMaker drinkMaker;

    public DrinkMakerProtocol(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void orderDrink(Drink drink) {
        drinkMaker.makeDrink(buildDrinkCommand(drink));
    }

    public void orderDrinkWithSugar(Drink drink, int nbSugars) {
        drinkMaker.makeDrink(buildDrinkWithSugarCommand(drink, nbSugars));
    }

    String buildDrinkCommand(Drink drink) {
        return drink.getCode()
                + COMMAND_SEPARATOR
                + COMMAND_SEPARATOR;
    }

    String buildDrinkWithSugarCommand(Drink drink, int nbSugars) {
        return drink.getCode()
                + COMMAND_SEPARATOR + nbSugars
                + COMMAND_SEPARATOR + STICK_CODE;
    }

    public void forwardMessage(String message) {
        drinkMaker.forwardMessage(buildMessageCommand(message));
    }

    String buildMessageCommand(String message) {
        return MESSAGE_CODE + COMMAND_SEPARATOR + message;
    }

}
