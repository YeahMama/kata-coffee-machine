public class Logic {
    public String parseToDrinkMakerProtocol(String drink, int nbOfSugars) {
        String instructions = "";

        if(Drink.Tea.name().equals(drink)) {
            instructions += Drink.Tea.getCode();
        } else if(Drink.Chocolate.name().equals(drink)) {
            instructions += Drink.Chocolate.getCode();
        } else if(Drink.Coffee.name().equals(drink)) {
            instructions += Drink.Coffee.getCode();
        }

        if(nbOfSugars > 0) {
            instructions += ":" + String.valueOf(nbOfSugars) + ":0";
        } else {
            instructions += "::";
        }

        return instructions;
    }
}
