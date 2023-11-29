package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(num -> convertNumberToString(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private String convertNumberToString(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        return "U";
    }
}
