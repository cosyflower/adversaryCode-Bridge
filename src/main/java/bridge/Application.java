package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeApplication bridgeApplication = new BridgeApplication(new InputView(),
                new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter()))
        );

        bridgeApplication.run();
    }
}
