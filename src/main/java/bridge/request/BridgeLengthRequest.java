package bridge.request;

import bridge.parser.Converter;
import bridge.parser.PatternRegex;

public class BridgeLengthRequest {
    private final String bridgeLengthRequest;

    public BridgeLengthRequest(String bridgeLengthRequest) {
        validateBridgeLengthRequest(bridgeLengthRequest);
        this.bridgeLengthRequest = bridgeLengthRequest;
    }

    public BridgeLength toBridgeLenth() {
        return BridgeLength.from(Converter.convertStringToNumber(bridgeLengthRequest));
    }


    private void validateBridgeLengthRequest(String bridgeLengthRequest) {
        isNullOrEmpty(bridgeLengthRequest);
        hasNumberPattern(bridgeLengthRequest);
        startsWithZero(bridgeLengthRequest);
    }

    private void startsWithZero(String bridgeLengthRequest) {
        if (bridgeLengthRequest.startsWith("0") && bridgeLengthRequest.length() > 1) {
            throw new IllegalArgumentException("0으로 시작하는 수는 0만 가능합니다.");
        }
    }

    private void isNullOrEmpty(String bridgeLengthRequest) {
        if (bridgeLengthRequest == null || bridgeLengthRequest.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasNumberPattern(String bridgeLengthRequest) {
        if (PatternRegex.NUMBER_PATTERN.matcher(bridgeLengthRequest).matches()) {
            return;
        }
        throw new IllegalArgumentException("수를 입력하지 않았습니다.");
    }
}
