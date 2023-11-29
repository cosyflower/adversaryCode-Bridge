package bridge;

import bridge.system.Digit;
import bridge.system.PlayerChoice;
import bridge.view.OutputView;
import bridge.view.pathPrinter.CurrentPathPrinter;
import bridge.view.pathPrinter.DownPathPrinter;
import bridge.view.pathPrinter.UpPathPrinter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void flow() {
        OutputView outputView = new OutputView(new CurrentPathPrinter(new DownPathPrinter(), new UpPathPrinter()));
        Map<PlayerChoice, Boolean> map = new HashMap<>();

        map.put(PlayerChoice.of("U", Digit.from(0)), true);
        map.put(PlayerChoice.of("D", Digit.from(1)), true);

        outputView.printMap(map);
    }

    @Test
    void fl() {
        List<String> stringList = Arrays.asList("O", " ", " ", "X");
        String joined = String.join(" | ", new String("LL"));

        System.out.println(joined);
    }
}
