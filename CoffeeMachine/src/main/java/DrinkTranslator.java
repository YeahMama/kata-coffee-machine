public class DrinkTranslator {
    private final static String STICK = "0";
    private final static String MESSAGE_CODE = "M";

    public String makeDrink(Drink drink, int nbOfSugars, double amount) {
        if(hasEnoughMoneyGiven(drink, amount)) {
            return toDrinkMaker(drink, nbOfSugars);
        }

        return notEnoughtMoneyGivenMessage(drink, amount);
    }

    private boolean hasEnoughMoneyGiven(Drink drink, double amount) {
        return amount >= drink.getPrice();
    }

    private String notEnoughtMoneyGivenMessage(Drink drink, double amount) {
        return "Need " + String.valueOf(drink.getPrice() - amount);
    }

    public String toCustomer(String commandFromDrinkMaker) {
        String[] commands = commandFromDrinkMaker.split(":");

        if(isMessageCommand(commands)) {
            return commands[1];
        }

        return "";
    }

    private boolean isMessageCommand(String[] commands) {
        return commands.length == 2 && MESSAGE_CODE.equals(commands[0]);
    }

    public String toDrinkMaker(Drink drink, int nbOfSugars) {
        return drink.getCode()
                + ":" + sugarCode(nbOfSugars)
                + ":" + stickCode(nbOfSugars);
    }

    private String sugarCode(int nbOfSugars) {
        return hasSugars(nbOfSugars)? String.valueOf(nbOfSugars) : "";
    }

    private String stickCode(int nbOfSugars) {
        return hasSugars(nbOfSugars)? STICK : "";
    }

    private boolean hasSugars(int nbOfSugars) {
        return nbOfSugars > 0;
    }
}
