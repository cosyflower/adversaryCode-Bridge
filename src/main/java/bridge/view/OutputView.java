package bridge.view;

import bridge.system.PlayerChoice;
import bridge.view.pathPrinter.CurrentPathPrinter;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final CurrentPathPrinter currentPathPrinter;

    public OutputView(CurrentPathPrinter currentPathPrinter) {
        this.currentPathPrinter = currentPathPrinter;
    }

    public void printMap(Map<PlayerChoice, Boolean> currentPath) {
        for (PlayerChoice playerChoice : currentPath.keySet()) {
            if (playerChoice.isFirstChoice()) {
                currentPathPrinter.initUpOrDown(playerChoice, currentPath.get(playerChoice));
                continue;
            }

            if (currentPath.get(playerChoice) == false) {
                currentPathPrinter.checkUpOrDownWhenWrong(playerChoice);
                break;
            }
            currentPathPrinter.checkUpOrDownWhenRight(playerChoice);
        }

        System.out.println(currentPathPrinter.getFinalPath());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void printUpPath() {

    }

    private void printDownPath() {

    }
}
