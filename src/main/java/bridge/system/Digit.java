package bridge.system;

public class Digit {
    private final int digitValue;

    private Digit(int digitValue) {
        this.digitValue = digitValue;
    }

    public static Digit from(int digitValue) {
        return new Digit(digitValue);
    }

    public int getDigitValue() {
        return digitValue;
    }
}
