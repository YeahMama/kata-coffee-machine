class DrinkTranslator {
    private final static String STICK_CODE = "0";
    private final static String MESSAGE_CODE = "M";

    String toDrinkMaker(Drink drink, int nbOfSugars) {
        return drink.getCode()
                + ":" + sugarCode(nbOfSugars)
                + ":" + stickCode(nbOfSugars);
    }

    private boolean hasSugars(int nbOfSugars) {
        return nbOfSugars > 0;
    }

    private String sugarCode(int nbOfSugars) {
        return hasSugars(nbOfSugars)? String.valueOf(nbOfSugars) : "";
    }

    private String stickCode(int nbOfSugars) {
        return hasSugars(nbOfSugars)? STICK_CODE : "";
    }


    String toCustomer(String instructionsFromDrinkMaker) {
        String[] instructions = instructionsFromDrinkMaker.split(":");

        if(isMessageInstruction(instructions[0])) {
            return displayMessage(instructions[1]);
        }

        return "";
    }

    private boolean isMessageInstruction(String instructionCode) {
        return MESSAGE_CODE.equals(instructionCode);
    }

    private String displayMessage(String instruction) {
        return instruction;
    }
}
