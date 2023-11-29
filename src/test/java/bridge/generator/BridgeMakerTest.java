package bridge.generator;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeNumberGenerator() {
            @Override
            public int generate() {
                return 0;
            }
        });

        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "D", "D");
    }
}
