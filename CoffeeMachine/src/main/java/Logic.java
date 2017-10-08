public class Logic {
    public final static String STICK = "0";

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

    public String parseToCustomer(String commands) {
        String[] commandsSplited = commands.split(":");

        if(commandsSplited.length == 2) {
            return commandsSplited[1];
        }

        return "";
    }
}
