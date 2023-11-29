package bridge.system;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.generator.BridgeMaker;
import bridge.system.Bridge;
import bridge.system.PlayerChoice;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @Test
    void 같은_digit_같은_값이면_True() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0); // 아래만 만든다
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(3));// DDD
        PlayerChoice playerChoice = PlayerChoice.of("D", 2);

        // Digit이 넘어가는 경우도 생각하기
        boolean expectedTrue = bridge.hasSameValueAtIndex(playerChoice);
        assertThat(expectedTrue).isEqualTo(true);
    }
}
