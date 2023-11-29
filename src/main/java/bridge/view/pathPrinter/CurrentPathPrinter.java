package bridge.view.pathPrinter;

import bridge.system.PlayerChoice;

public class CurrentPathPrinter {
    private final DownPathPrinter downPrinter;
    private final UpPathPrinter upPrinter;

    public CurrentPathPrinter(DownPathPrinter downPrinter, UpPathPrinter upPrinter) {
        this.downPrinter = downPrinter;
        this.upPrinter = upPrinter;
    }


    public void checkUpOrDownWhenRight(PlayerChoice playerChoice) {
        if (playerChoice.isDown()) {
            upPrinter.printWhiteSpace();
            downPrinter.appendRightPath();
            return;
        }

        if (playerChoice.isUp()) {
            upPrinter.appendRightPath();
            downPrinter.printWhiteSpace();
        }
    }

    public void checkUpOrDownWhenWrong(PlayerChoice playerChoice) {
        if (playerChoice.isDown()) {
            upPrinter.printWhiteSpace();
            downPrinter.appendWrongPath();
            return;
        }

        if (playerChoice.isUp()) {
            upPrinter.appendWrongPath();
            downPrinter.printWhiteSpace();
        }
    }

    public String getFinalPath() {
        upPrinter.endPath();
        downPrinter.endPath();

        String upPath = upPrinter.finalPath();
        String downPath = downPrinter.finalPath();

        return upPath + "\n" + downPath;
    }

    public void initUpOrDown(PlayerChoice playerChoice, Boolean rightOrWrong) {
        if (rightOrWrong == true) {
            initUpOrDownWhenRight(playerChoice);
            return;
        }
        initUpOrDownWhenWrong(playerChoice);
    }

    private void initUpOrDownWhenRight(PlayerChoice playerChoice) {
        if (playerChoice.isDown()) {
            upPrinter.appendFirstWhiteSpace();
            downPrinter.appendFirstRightPath();
            return;
        }

        if (playerChoice.isUp()) {
            upPrinter.appendFirstRightPath();
            downPrinter.appendFirstWhiteSpace();
        }
    }

    private void initUpOrDownWhenWrong(PlayerChoice playerChoice) {
        if (playerChoice.isDown()) {
            upPrinter.appendFirstWhiteSpace();
            downPrinter.appendFirstWrongPath();
            return;
        }

        if (playerChoice.isUp()) {
            upPrinter.appendFirstWrongPath();
            downPrinter.appendFirstWhiteSpace();
        }
    }

}
