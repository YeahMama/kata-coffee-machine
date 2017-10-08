public class Logic {
    public String parseToDrinkMakerProtocol(String drink, int nbOfSugars) {
        String instructions = "";
        if("Tea".equals(drink)) {
            instructions += "T";
        } else if("Chocolate".equals(drink)) {
            instructions += "H";
        } else if("Coffee".equals(drink)) {
            instructions += "C";
        }

        if(nbOfSugars > 0) {
            instructions += ":" + String.valueOf(nbOfSugars) + ":0";
        } else {
            instructions += "::";
        }

        return instructions;
    }
}
