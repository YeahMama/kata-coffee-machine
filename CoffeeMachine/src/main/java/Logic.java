public class Logic {
    public String parseToDrinkMakerProtocol(String drink, int nbOfSugars) {
        String instructions = "";
        if("Tea".equals(drink)) {
            instructions += "T";
        }

        if(nbOfSugars > 0) {
            instructions += ":" + String.valueOf(nbOfSugars) + ":0";
        }

        return instructions;
    }
}
