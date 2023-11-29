package bridge.system;

import bridge.generator.BridgeMaker;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @Test
    void 지나온_경로_틀리면_검증() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0); // 아래만 만든다
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(3));// DDD
        BridgeGame bridgeGame = BridgeGame.from(bridge, new HashMap<>());

        PlayerChoice playerChoice = PlayerChoice.of("U", Digit.from(0));
        bridgeGame.checkBridgeAndChoice(playerChoice);
    }

    @Test
    void 지나온_경로_맞다면_검증() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0); // 아래만 만든다
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(3));// DDD
        BridgeGame bridgeGame = BridgeGame.from(bridge, new HashMap<>());

        PlayerChoice playerChoice = PlayerChoice.of("D", Digit.from(0));
        bridgeGame.checkBridgeAndChoice(playerChoice);
    }
}
