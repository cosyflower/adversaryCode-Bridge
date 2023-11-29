package bridge.request;

public class Retry {
    private final String retryValue;

    private Retry(String retryValue) {
        validateRetryValue(retryValue);
        this.retryValue = retryValue;
    }

    public static Retry from(String retryValue) {
        return new Retry(retryValue);
    }

    private void validateRetryValue(String retryValue) {
        isValidWord(retryValue);
    }

    private void isValidWord(String retryValue) {
        if (retryValue.equals("Q") || retryValue.equals("R")) {
            return;
        }
        throw new IllegalArgumentException("Q나 R만 입력이 가능합니다.");
    }
}
