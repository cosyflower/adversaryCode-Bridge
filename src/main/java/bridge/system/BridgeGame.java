package bridge.system;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.LinkedHashMap;
import java.util.Map;

public class BridgeGame {
    private final Bridge bridge;
    private final Map<PlayerChoice, Boolean> currentPath; // PlayerChoice, Boolean 이 맞다
    private final OutputView outputView;
    private final InputView inputView;

    private int autoDigit;
    private int tryTotal;

    private BridgeGame(Bridge bridge, OutputView outputView, InputView inputView) {
        this.bridge = bridge;
        this.currentPath = new LinkedHashMap<>();
        this.outputView = outputView;
        this.inputView = inputView;
        initBridgeGame();
    }

    private void initBridgeGame() {
        autoDigit = 0;
        tryTotal = 1;
    }

    public static BridgeGame from(Bridge bridge, OutputView outputView, InputView inputView) {
        return new BridgeGame(bridge, outputView, inputView);
    }

    public void startGame() {
        PlayerChoice playerChoice = createPlayerChoice();
        checkBridgeAndChoice(playerChoice);
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
        checkBridgeAndChoice(playerChoice);
    }

    private void restartGame() {
        tryTotal++;
        autoDigit = 0;
        currentPath.clear();
        PlayerChoice playerChoice = createPlayerChoice();
        checkBridgeAndChoice(playerChoice);
    }

    private PlayerChoice createPlayerChoice() {
        String anotherMove = new InputView().readMoving();
        PlayerChoice playerChoice = PlayerChoice.of(anotherMove, Digit.from(autoDigit));
        return playerChoice;
    }

    private void showCurrentPath() {
        outputView.printMap(currentPath);
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
