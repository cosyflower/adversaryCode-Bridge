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

    public boolean isFirstChoice() {
        return getDigitValue() == 0;
    }

    public int getDigitValue() {
        return digit.getDigitValue();
    }

    public boolean isDown() {
        return upOrDown == "D";
    }

    public boolean isUp() {
        return upOrDown == "U";
    }
}
