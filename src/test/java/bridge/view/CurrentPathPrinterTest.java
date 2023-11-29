package bridge.view;

import bridge.system.Digit;
import bridge.system.PlayerChoice;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;
import org.junit.jupiter.api.Test;

public class CurrentPathPrinterTest {
    @Test
    void finalPath_initUpOrDown_검증() {
        CurrentPathPrinter currentPathPrinter = new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter());

        currentPathPrinter.initUpOrDown(PlayerChoice.of("U", Digit.from(0)), true);
        currentPathPrinter.checkUpOrDownWhenRight(PlayerChoice.of("U", Digit.from(0)));

        String finalPath = currentPathPrinter.getFinalPath();
        System.out.println(finalPath);
    }

    @Test
    void finalPath_검증() {
        CurrentPathPrinter currentPathPrinter = new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter());

        currentPathPrinter.initUpOrDown(PlayerChoice.of("U", Digit.from(0)), true);
        currentPathPrinter.checkUpOrDownWhenWrong(PlayerChoice.of("D", Digit.from(0))); // Digit 연연하지 않음

        String finalPath = currentPathPrinter.getFinalPath();
        System.out.println(finalPath);
    }
}
