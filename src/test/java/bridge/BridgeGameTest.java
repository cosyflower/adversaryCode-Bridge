package bridge;

import bridge.generator.BridgeMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @Test
    void 다리와_이동할_칸이_같다면_True() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));

        PlayerChoice playerChoice = new PlayerChoice("U");

        BridgeGame.compareBridgeAndChoice(bridge, playerChoice);
        BridgeGame.compareBridgeAndChoice(bridge, playerChoice);

        String currentPath = BridgeGame.createCurrentPath();
        Assertions.assertThat(currentPath).isEqualTo("O | O" + "\n" + "  |  ");
    }

    @Test
    void 다리와_이동할_칸이_달면_False() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 1); // UUU로 생성한다
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));

        PlayerChoice playerChoice = new PlayerChoice("D");

        BridgeGame.compareBridgeAndChoice(bridge, playerChoice);
        BridgeGame.compareBridgeAndChoice(bridge, playerChoice);
        BridgeGame.compareBridgeAndChoice(bridge, playerChoice);

        String currentPath = BridgeGame.createCurrentPath();
        Assertions.assertThat(currentPath).isEqualTo("  |   |  " + "\n" + "X | X | X");
    }
}
