package bridge.system;

public class PlayerChoice {
    private final String upOrDown;
    private Digit digit;

    private PlayerChoice(String upOrDown, Digit digit) {
        this.upOrDown = upOrDown;
        this.digit = digit;
    }

    public static PlayerChoice of(String upOrDown, Digit digit) {
        return new PlayerChoice(upOrDown, digit);
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public int getDigitValue() {
        return digit.getDigitValue();
    }
}
