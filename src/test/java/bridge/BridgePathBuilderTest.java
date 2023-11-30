package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BridgePathBuilderTest {
    @Test
    void flw() {
        List<ResultMatch> resultMatchList = new ArrayList<>();
        resultMatchList.add(ResultMatch.of(new PlayerChoice("U"), true));
        resultMatchList.add(ResultMatch.of(new PlayerChoice("D"), true));
        resultMatchList.add(ResultMatch.of(new PlayerChoice("U"), false));

        BridgePathBuilder pathBuilder = BridgePathBuilder.from(resultMatchList);
        String expectedString = pathBuilder.buildSpecificPath("U");

        assertThat(expectedString).isEqualTo("O |   | X");
    }

    @Test
    void up_Down_Path_검증() {
        List<ResultMatch> resultMatchList = new ArrayList<>();
        resultMatchList.add(ResultMatch.of(new PlayerChoice("U"), true));
        resultMatchList.add(ResultMatch.of(new PlayerChoice("D"), true));
        resultMatchList.add(ResultMatch.of(new PlayerChoice("U"), false));

        BridgePathBuilder pathBuilder = BridgePathBuilder.from(resultMatchList);

        String expectedUpPath = pathBuilder.buildSpecificPath("U");
        String expectedDownPath = pathBuilder.buildSpecificPath("D");

        assertThat(expectedUpPath).isEqualTo("O |   | X");
        assertThat(expectedDownPath).isEqualTo("  | O |  ");
    }
}
