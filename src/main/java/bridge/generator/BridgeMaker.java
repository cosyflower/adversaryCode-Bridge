package bridge.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {
    private final BridgeNumberGenerator generator;
    public BridgeMaker(BridgeNumberGenerator numberGenerator) {
        generator = numberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(num -> convertNumberToString(generator.generate()))
                .collect(Collectors.toList());
    }

    private String convertNumberToString(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        return "U";
    }
}
