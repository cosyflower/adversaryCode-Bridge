package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridgeValues;

    private Bridge(List<String> convertedBridges) {
        this.bridgeValues = convertedBridges;
    }

    public static Bridge from(List<String> bridgeValues) {
        return new Bridge(bridgeValues);
    }

    public boolean hasSameValueAtIndex(PlayerChoice playerChoice) {
        int digit = playerChoice.getDigit();
        String upOrDown = playerChoice.getUpOrDown();

        if (bridgeValues.get(digit).equals(upOrDown)) {
            return true;
        }
        return false;
    }
}
