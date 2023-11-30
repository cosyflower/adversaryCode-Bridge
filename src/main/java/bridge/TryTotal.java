package bridge;

public class TryTotal {
    private final int tryTotalValue;

    private TryTotal(int tryTotalValue) {
        this.tryTotalValue = tryTotalValue;
    }

    public static TryTotal from(int defaultTryTotalValue) {
        return new TryTotal(defaultTryTotalValue);
    }

    public TryTotal incrementRetryValue() {
        return TryTotal.from(tryTotalValue + 1);
    }
}
