package bridge.system;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeNumberGenerator;
import bridge.system.PlayerChoice;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerChoiceTest {
    @Test
    void flow() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeNumberGenerator() {
            @Override
            public int generate() {
                return 0;
            }
        });

        List<String> bridge = bridgeMaker.makeBridge(3);
        PlayerChoice playerChoice = PlayerChoice.of( "D",0);

        Boolean result = bridge.get(playerChoice.getDigit()) == playerChoice.getUpOrDown();
        Assertions.assertThat(result).isEqualTo(true);
    }
}
