package domain;

import org.apache.commons.lang3.StringUtils;

class DrinkTranslator {
    private static final String STICK_CODE = "0";
    private static final String MESSAGE_CODE = "M";

    String toDrinkMaker(Drink drink, int nbOfSugars) {
        return drink.getCode()
                + ":" + sugarCode(nbOfSugars)
                + ":" + stickCode(nbOfSugars);
    }

    private boolean hasSugars(int nbOfSugars) {
        return nbOfSugars > 0;
    }

    private String sugarCode(int nbOfSugars) {
        return hasSugars(nbOfSugars) ? String.valueOf(nbOfSugars) : StringUtils.EMPTY;
    }

    private String stickCode(int nbOfSugars) {
        return hasSugars(nbOfSugars) ? STICK_CODE : StringUtils.EMPTY;
    }


    String toCustomer(String instructionsFromDrinkMaker) {
        String[] instructions = instructionsFromDrinkMaker.split(":");

        if (isMessageInstruction(instructions[0])) {
            return displayMessage(instructions[1]);
        }

        return StringUtils.EMPTY;
    }

    private boolean isMessageInstruction(String instructionCode) {
        return MESSAGE_CODE.equals(instructionCode);
    }

    private String displayMessage(String instruction) {
        return instruction;
    }
}
