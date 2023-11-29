package bridge.system;

import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.OutputView;
import bridge.view.pathPrinter.UpPathPrinter;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Map<PlayerChoice, Boolean> currentPath; // PlayerChoice, Boolean 이 맞다

    private BridgeGame(Bridge bridge, Map<PlayerChoice, Boolean> currentPath) {
        this.bridge = bridge;
        this.currentPath = currentPath;
    }

    public static BridgeGame from(Bridge bridge, Map<PlayerChoice, Boolean> currentPath) {
        return new BridgeGame(bridge, currentPath);
    }

    public void checkBridgeAndChoice(PlayerChoice playerChoice) {
        if (bridge.hasSameValueAtIndex(playerChoice)) {
            currentPath.put(playerChoice, true);
            move();
            return;
        }

        currentPath.put(playerChoice, false);
        retry();
    }

    public void move() {
        showCurrentPath();

    }


    public void retry() {
        showCurrentPath();
    }

    private void showCurrentPath() {
        // 지금까지의 PlayerChoice를 유지해야 한다
        // Map<Integer(digit), String upOrDown) -> upOrDown Enum으로도 가능함
        new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter())).printMap(currentPath);

    }
}
