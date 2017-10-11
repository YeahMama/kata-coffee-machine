public class DrinkTranslator {
    private final static String STICK_CODE = "0";
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

    public String toCustomer(String instructionsFromDrinkMaker) {
        String[] instructions = instructionsFromDrinkMaker.split(":");

        if(isMessageInstructions(instructions)) {
            return displayMessage(instructions[1]);
        }

        return "";
    }

    private String displayMessage(String instruction) {
        return instruction;
    }

    private boolean isMessageInstructions(String[] instructions) {
        return (instructions.length == 2) && (MESSAGE_CODE.equals(instructions[0]));
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
        return hasSugars(nbOfSugars)? STICK_CODE : "";
    }

    private boolean hasSugars(int nbOfSugars) {
        return nbOfSugars > 0;
    }
}
