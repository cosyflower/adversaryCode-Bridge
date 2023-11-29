package bridge.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeLengthRequestTest {
    @Nested
    class 성공 {

        @Nested
        class BridgeLengthRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new BridgeLengthRequest("0"))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        class BridgeLength_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new BridgeLengthRequest("3").toBridgeLength())
                        .doesNotThrowAnyException();
            }
        }

    }

    @Nested
    class 예외 {
        @Nested
        class BridgeLengthRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new BridgeLengthRequest("012"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0만 가능합니다.");
            }
        }

        @Nested
        class BridgeLength_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new BridgeLengthRequest("0").toBridgeLength())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("범위에서");
            }
        }
    }
}
