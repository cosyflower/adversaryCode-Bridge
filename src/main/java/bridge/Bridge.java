package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridgeValues;

    public Bridge(List<String> bridgeValues) {
        this.bridgeValues = new ArrayList<>(bridgeValues);
    }

    public boolean compareSpecificDigit(Digit digit, PlayerChoice playerChoice) {
        if (hasSameValueAtIndex(digit, playerChoice)) {
            return true;
        }
        return false;
    }

    private boolean hasSameValueAtIndex(Digit digit, PlayerChoice playerChoice) {
        return bridgeValues.get(digit.getDigitValue()).equals(playerChoice.getPlayerChoiceValue());
    }

    public boolean hasSameLength(Digit digit) {
        return bridgeValues.size() == digit.getDigitValue() - 1;
    }
}
