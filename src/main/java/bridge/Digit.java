package bridge;

public class Digit {
    private final int digitValue;

    private Digit(int digit) {
        this.digitValue = digit;
    }

    public static Digit from(int defaultValue) {
        return new Digit(0);
    }

    public Digit increaseValue() {
        return Digit.from(digitValue + 1);
    }

    public Digit clearValue() {
        return Digit.from(0);
    }

    public int getDigitValue() {
        return digitValue;
    }
}
