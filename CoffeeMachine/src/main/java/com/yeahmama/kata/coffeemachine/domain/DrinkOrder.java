package com.yeahmama.kata.coffeemachine.domain;

import com.yeahmama.kata.coffeemachine.infrastructure.DrinkMakerProtocol;

public class DrinkOrder {

    private DrinkMakerProtocol drinkMakerProtocol;

    public DrinkOrder(DrinkMakerProtocol drinkMakerProtocol) {
        this.drinkMakerProtocol = drinkMakerProtocol;
    }

    void orderDrink(Drink drink, int nbSugars, double amount) {
        if (hasEnoughMoney(drink, amount)) {
            if (hasSugars(nbSugars)) {
                drinkMakerProtocol.orderDrinkWithSugar(drink, nbSugars);
            } else {
                drinkMakerProtocol.orderDrink(drink);
            }
        } else {
            drinkMakerProtocol.forwardMessage(notEnoughMoneyMessage(drink, amount));
        }
    }

    private boolean hasEnoughMoney(Drink drink, double amount) {
        return amount >= drink.getPrice();
    }

    private String notEnoughMoneyMessage(Drink drink, double amount) {
        return "Need " + (drink.getPrice() - amount);
    }

    private boolean hasSugars(int nbSugars) {
        return nbSugars > 0;
    }

}
