package bridge.request;

public class MovingDirection {
    private final String movingDirectionValue;

    private MovingDirection(String movingDirectionValue) {
        validateMovingDirectionValue(movingDirectionValue);
        this.movingDirectionValue = movingDirectionValue;
    }

    public static MovingDirection from(String movingDirectionValue) {
        return new MovingDirection(movingDirectionValue);
    }

    private void validateMovingDirectionValue(String movingDirectionValue) {
        isValidWord(movingDirectionValue);
    }

    private void isValidWord(String movingDirectionValue) {
        if (movingDirectionValue.equals("U") || movingDirectionValue.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("U나 D를 입력해주세요.");
    }
}
