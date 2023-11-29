package bridge.request;

import bridge.parser.PatternRegex;

public class MovingDirectionRequest {
    private final String movingDirectionRequest;

    public MovingDirectionRequest(String movingDirectionRequest) {
        validateMovingDirectionRequest(movingDirectionRequest);
        this.movingDirectionRequest = movingDirectionRequest;
    }

    public MovingDirection toMovingDirection() {
        return MovingDirection.from(movingDirectionRequest);
    }

    private void validateMovingDirectionRequest(String movingDirectionRequest) {
        isNullOrEmpty(movingDirectionRequest);
        hasWordPattern(movingDirectionRequest);
    }

    private void isNullOrEmpty(String movingDirectionRequest) {
        if (movingDirectionRequest == null || movingDirectionRequest.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasWordPattern(String movingDirectionRequest) {
        if (PatternRegex.WORD_PATTERN.matcher(movingDirectionRequest).matches()) {
            return;
        }
        throw new IllegalArgumentException("문자를 입력하지 않았습니다.");
    }

}
