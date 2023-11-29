package bridge.system;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridgeValues;

    private Bridge(List<String> convertedBridges) {
        this.bridgeValues = new ArrayList<>(convertedBridges);
    }

    public static Bridge from(List<String> bridgeValues) {
        return new Bridge(bridgeValues);
    }

    public boolean hasSameValueAtIndex(PlayerChoice playerChoice) {
        int digitValue = playerChoice.getDigitValue();
        String upOrDown = playerChoice.getUpOrDown();

        if (bridgeValues.get(digitValue).equals(upOrDown)) {
            return true;
        }
        return false;
    }

    public int getBridgeLength() {
        return bridgeValues.size();
    }
}
