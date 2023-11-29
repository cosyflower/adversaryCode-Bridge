package bridge.system;

import bridge.generator.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @Test
    void 지나온_경로_틀리면_검증() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0); // 아래만 만든다
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(3));// DDD
        BridgeGame bridgeGame = BridgeGame.from(bridge,
                new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter())),
                new InputView());

        PlayerChoice playerChoice = PlayerChoice.of("U", Digit.from(0));
        bridgeGame.checkBridgeAndChoice(playerChoice);
    }

    @Test
    void 지나온_경로_맞다면_검증() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0); // 아래만 만든다
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(3));// DDD
        BridgeGame bridgeGame = BridgeGame.from(bridge,
                new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter())),
                new InputView());

        PlayerChoice playerChoice = PlayerChoice.of("D", Digit.from(0));
        bridgeGame.checkBridgeAndChoice(playerChoice);
    }
}
