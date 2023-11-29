package bridge.system;

public class PlayerChoice {
    private final String upOrDown;
    private int digit;

    private PlayerChoice(String upOrDown, int digit) {
        this.upOrDown = upOrDown;
        this.digit = digit;
    }

    public static PlayerChoice of(String upOrDown, int digit) {
        return new PlayerChoice(upOrDown, digit);
    }

    public String getUpOrDown() {
        return upOrDown;
    }

    public int getDigit() {
        return digit;
    }
}
