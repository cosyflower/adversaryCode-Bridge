package bridge.request;

public class BridgeLength {
    private final int bridgeLengthValue;

    private BridgeLength(int bridgeLengthValue) {
        validateBridgeLength(bridgeLengthValue);
        this.bridgeLengthValue = bridgeLengthValue;
    }

    public static BridgeLength from(int convertStringToNumber) {
        return new BridgeLength(convertStringToNumber);
    }

    private void validateBridgeLength(int bridgeLengthValue) {
        isInRange(bridgeLengthValue);
    }

    private void isInRange(int bridgeLengthValue) {
        if (bridgeLengthValue < 3 || bridgeLengthValue > 20) {
            throw new IllegalArgumentException("범위에서 벗어난 수입니다.");
        }
    }

    public int getBridgeLengthValue() {
        return bridgeLengthValue;
    }
}
