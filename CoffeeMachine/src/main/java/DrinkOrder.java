class DrinkOrder {

    private DrinkTranslator drinkTranslator;

    DrinkOrder() {
        this.drinkTranslator = new DrinkTranslator();
    }

    String makeDrink(Drink drink, int nbOfSugars, double amount) {
        if(hasEnoughMoneyGiven(drink, amount)) {
            return drinkTranslator.toDrinkMaker(drink, nbOfSugars);
        }

        return notEnoughtMoneyGivenMessage(drink, amount);
    }

    private boolean hasEnoughMoneyGiven(Drink drink, double amount) {
        return amount >= drink.getPrice();
    }

    private String notEnoughtMoneyGivenMessage(Drink drink, double amount) {
        return "Need " + String.valueOf(drink.getPrice() - amount);
    }
}
