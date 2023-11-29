package bridge.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MovingDirectionRequestTest {
    @Nested
    class 성공 {

        @Nested
        class MovingDirectionRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new MovingDirectionRequest("U"))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        class MovingDirection_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new MovingDirectionRequest("U").toMovingDirection())
                        .doesNotThrowAnyException();
            }
        }

    }

    @Nested
    class 예외 {
        @Nested
        class MovingDirectionRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new MovingDirectionRequest("|"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("문자를 입력하지 않았습니다.");
            }
        }

        @Nested
        class MovingDirection_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new MovingDirectionRequest("A").toMovingDirection())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("U나 D를");
            }
        }
    }
}
