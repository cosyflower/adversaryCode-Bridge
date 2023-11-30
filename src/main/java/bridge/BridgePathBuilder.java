package bridge;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgePathBuilder {
    private final StringBuilder pathBuilder;
    private final Map<PlayerChoice, Boolean> playerChoiceBooleanMap;

    private BridgePathBuilder(Map<PlayerChoice, Boolean> playerMap){
        pathBuilder = new StringBuilder();
        playerChoiceBooleanMap = Collections.unmodifiableMap(playerMap);
    }

    public static BridgePathBuilder from(Map<PlayerChoice, Boolean> playerMap) {
        return new BridgePathBuilder(playerMap);
    }

    public String buildSpecificPath(String playerChoiceValue) {
        pathBuilder.setLength(0);

        for (PlayerChoice playerChoice : playerChoiceBooleanMap.keySet()) {
            Boolean rightOrWrong = playerChoiceBooleanMap.get(playerChoice);
            if (playerChoice.hasSameValue(playerChoiceValue)) {
                checkRightOrWrong(rightOrWrong);
                continue;
            }
            appendWithSpace();
        }

        return joinSeparatorInPath(pathBuilder.toString());
    }

    private void appendWithSpace() {
        pathBuilder.append(" ");
    }

    private String joinSeparatorInPath(String builtPath) {
        List<String> convertedStringList = IntStream.range(0, builtPath.length())
                .mapToObj(num -> String.valueOf(builtPath.charAt(num)))
                .collect(Collectors.toList());

        return String.join(" | ", convertedStringList);
    }

    private void checkRightOrWrong(Boolean rightOrWrong) {
        if (rightOrWrong) {
            pathBuilder.append("O");
            return;
        }
        pathBuilder.append("X");
    }
}
