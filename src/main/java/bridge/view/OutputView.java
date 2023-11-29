package bridge.view;

import bridge.system.PlayerChoice;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private CurrentPathPrinter currentPathPrinter;

    public OutputView(CurrentPathPrinter currentPathPrinter) {
        this.currentPathPrinter = currentPathPrinter;
    }

    public void printMap(Map<PlayerChoice, Boolean> currentPath) {
        currentPathPrinter = new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter());
        for (PlayerChoice playerChoice : currentPath.keySet()) {
            System.out.println("playerChoice.getDigitValue() = " + playerChoice.getDigitValue());
            System.out.println("playerChoice.getUpOrDown() = " + playerChoice.getUpOrDown());
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

    public void printResult(boolean successOrFailure, int tryTotal) {
        System.out.print("게임 성공 여부: ");
        if (successOrFailure == true) {
            System.out.println("성공");
            System.out.printf("총 시도한 횟수: %d\n", tryTotal);
            return;
        }
        System.out.println("실패");
        System.out.printf("총 시도한 횟수: %d\n", tryTotal);
    }

    public void showStartingMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printLine() {
        System.out.println();
    }
}
