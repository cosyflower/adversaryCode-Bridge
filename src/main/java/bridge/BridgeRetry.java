package bridge;

public class BridgeRetry {
    private final String bridgeRetryValue;

    public BridgeRetry(String bridgeRetryValue) {
        this.bridgeRetryValue = bridgeRetryValue;
    }

    public boolean isRetryValue() {
        return bridgeRetryValue.equals("R");
    }
}
