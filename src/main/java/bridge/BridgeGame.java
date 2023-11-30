package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final static List<ResultMatch> resultMatches = new ArrayList<>(); // clear 해줘야 한다
    public static TryTotal tryTotal = TryTotal.from(1);
    private static Digit digit = Digit.from(0);


    public static String createCurrentPath() {
        // [ %s ] 형태로 출력한다 - outputView
        BridgePathBuilder bridgePathBuilder = BridgePathBuilder.from(resultMatches);
        String upPath = bridgePathBuilder.buildSpecificPath("U");
        String downPath = bridgePathBuilder.buildSpecificPath("D");

        return upPath + "\n" + downPath;
    }

    public static Boolean compareBridgeAndChoice(Bridge bridge, PlayerChoice playerChoice) {
        // Bridge -> BridgeMaker에서 BridgeLengthRequet.toBridgeLength를 활용해서 생성한다
        // PlayerChoice from playerChoiceRequest.toPlayerChoice()

        // 공통적으로 경로를 출력해야 한다
        // True 다음 값을 입력받는다 (입력받는 것은 RegisterController에서 진행한다)
        // False 재실행 여부를 입력받는다
        if (bridge.compareSpecificDigit(digit, playerChoice)) {
            resultMatches.add(ResultMatch.of(playerChoice, true));
            incrementDigit();
            return true;
        }
        resultMatches.add(ResultMatch.of(playerChoice, false));
        clearDigit();
        return false;
    }

    public static Boolean isRetry(BridgeRetry retryOrTerminate) {
        // BridgeRetry - BridgeRetryRequest.toBridgeRetry() 로 해결 가능함
        if (retryOrTerminate.isRetryValue()) {
            incrementRetry();
            resetResultMatches();
            return true;
        }
        return false;
    }

    private static void resetResultMatches() {
        resultMatches.clear();
    }

    public static Boolean isSuccessOrFail(Bridge bridge) {
        if (bridge.hasSameLength(digit)) {
            return true;
        }
        return false;
    }

    private static void incrementRetry() {
        tryTotal = tryTotal.incrementRetryValue();
    }

    private static void incrementDigit() {
        digit = digit.increaseValue();
    }

    private static void clearDigit() {
        digit = digit.clearValue();
    }
}
