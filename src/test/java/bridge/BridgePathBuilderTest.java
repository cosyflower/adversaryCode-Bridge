package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BridgePathBuilderTest {
    @Test
    void flw() {
        Map<PlayerChoice, Boolean> map = new LinkedHashMap<>();
        map.put(new PlayerChoice("U"), true);
        map.put(new PlayerChoice("D"), true);
        map.put(new PlayerChoice("U"), false);

        BridgePathBuilder pathBuilder = BridgePathBuilder.from(map);
        String expectedString = pathBuilder.buildSpecificPath("U");

        assertThat(expectedString).isEqualTo("O |   | X");
    }

    @Test
    void up_Down_Path_검증() {
        Map<PlayerChoice, Boolean> map = new LinkedHashMap<>();
        map.put(new PlayerChoice("U"), true);
        map.put(new PlayerChoice("D"), true);
        map.put(new PlayerChoice("U"), false);

        BridgePathBuilder pathBuilder = BridgePathBuilder.from(map);
        String expectedUpPath = pathBuilder.buildSpecificPath("U");
        String expectedDownPath = pathBuilder.buildSpecificPath("D");

        assertThat(expectedUpPath).isEqualTo("O |   | X");
        assertThat(expectedDownPath).isEqualTo("  | O |  ");
    }
}
