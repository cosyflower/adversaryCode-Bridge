package bridge;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.request.BridgeLength;
import bridge.request.BridgeLengthRequest;
import bridge.system.Bridge;
import bridge.system.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.showStartingMessage();
        BridgeLengthRequest bridgeLengthRequest = new BridgeLengthRequest(inputView.readBridgeSize());
        BridgeLength bridgeLength = bridgeLengthRequest.toBridgeLength();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = Bridge.from(bridgeMaker.makeBridge(bridgeLength.getBridgeLengthValue()));

        BridgeGame bridgeGame = BridgeGame.from(bridge, outputView, inputView);
        bridgeGame.startGame();
    }
}
