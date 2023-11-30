package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgePathBuilder {
    private final StringBuilder pathBuilder;
    private final List<ResultMatch> finalResultMatches;

    private BridgePathBuilder(List<ResultMatch> resultMatches){
        pathBuilder = new StringBuilder();
        finalResultMatches = new ArrayList<>(resultMatches);
    }

    public static BridgePathBuilder from(List<ResultMatch> resultMatches) {
        return new BridgePathBuilder(resultMatches);
    }

    public String buildSpecificPath(String playerChoiceValue) {
        pathBuilder.setLength(0);
        for (ResultMatch finalResultMatch : finalResultMatches) {
            if (finalResultMatch.hasSameValue(playerChoiceValue)) {
                checkRightOrWrong(finalResultMatch);
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

    private void checkRightOrWrong(ResultMatch resultMatch) {
        if (resultMatch.isRight()) {
            pathBuilder.append("O");
            return;
        }
        pathBuilder.append("X");
    }
}
