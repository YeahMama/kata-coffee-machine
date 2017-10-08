public class Logic {
    public final static String STICK = "0";
    public final static String MESSAGE_CODE = "M";

    public String makeDrink(Drink drink, int nbOfSugars, double amount) {
        if(amount >= drink.getPrice()) {
            return parseToDrinkMakerProtocol(drink, nbOfSugars);
        }

        return "Need " + String.valueOf(drink.getPrice() - amount);
    }

    public String parseToCustomer(String commandFromDrinkMaker) {
        String[] commands = commandFromDrinkMaker.split(":");

        if(commands.length == 2 && MESSAGE_CODE.equals(commands[0])) {
            return commands[1];
        }

        return "";
    }

    public String parseToDrinkMakerProtocol(Drink drink, int nbOfSugars) {
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
