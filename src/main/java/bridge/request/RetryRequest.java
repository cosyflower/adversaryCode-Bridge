package bridge.request;

import bridge.parser.PatternRegex;

public class RetryRequest {
    private final String retryRequest;

    public RetryRequest(String retryRequest) {
        validateRetryRequest(retryRequest);
        this.retryRequest = retryRequest;
    }

    public Retry toRetry() {
        return Retry.from(retryRequest);
    }

    private void validateRetryRequest(String retryRequest) {
        isNullOrEmpty(retryRequest);
        hasWordPattern(retryRequest);
    }

    private void isNullOrEmpty(String retryRequest) {
        if (retryRequest == null || retryRequest.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasWordPattern(String retryRequest) {
        if (PatternRegex.WORD_PATTERN.matcher(retryRequest).matches()) {
            return;
        }
        throw new IllegalArgumentException("문자를 입력하지 않았습니다.");
    }


}
