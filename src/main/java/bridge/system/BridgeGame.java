package bridge.system;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;
import java.util.Map;

public class BridgeGame {
    private final Bridge bridge;
    private final Map<PlayerChoice, Boolean> currentPath; // PlayerChoice, Boolean 이 맞다
    private final OutputView outputView;
    private final InputView inputView;

    private int autoDigit;
    private int tryTotal;

    private BridgeGame(Bridge bridge, Map<PlayerChoice, Boolean> currentPath, OutputView outputView,
                       InputView inputView) {
        this.bridge = bridge;
        this.currentPath = currentPath;
        this.outputView = outputView;
        this.inputView = inputView;
        initBridgeGame();
    }

    private void initBridgeGame() {
        autoDigit = 0;
        tryTotal = 0;
    }

    public static BridgeGame from(Bridge bridge, Map<PlayerChoice, Boolean> currentPath,
                                  OutputView outputView, InputView inputView) {
        return new BridgeGame(bridge, currentPath, outputView, inputView);
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
        askAnotherMove();
    }

    public void retry() {
        showCurrentPath();
        askTerminate();
    }

    private void askAnotherMove() {
        autoDigit++;
        PlayerChoice playerChoice = createPlayerChoice();
        tryTotal++;
        checkBridgeAndChoice(playerChoice);
    }

    private void restartGame() {
        autoDigit = 0;
        PlayerChoice playerChoice = createPlayerChoice();
        tryTotal++;
        checkBridgeAndChoice(playerChoice);
    }

    private PlayerChoice createPlayerChoice() {
        String anotherMove = new InputView().inputMove();
        PlayerChoice playerChoice = PlayerChoice.of(anotherMove, Digit.from(autoDigit));
        return playerChoice;
    }

    private void showCurrentPath() {
        new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter())).printMap(currentPath);
    }

    private void askTerminate() {
        String terminateOrRestart = new InputView().readGameCommand();
        if (isTerminate(terminateOrRestart)) {
            endGame();
            return;
        }
        restartGame();
    }

    private boolean isTerminate(String terminateOrRestart) {
        if (terminateOrRestart.equals("Q")) {
            return true;
        }
        return false;
    }

    private void endGame() {
        showResult();
    }

    private void showResult() {
        if (autoDigit == bridge.getBridgeLength()) {
            outputView.printResult(true, tryTotal);
        }
        outputView.printResult(false, tryTotal);
    }
}
