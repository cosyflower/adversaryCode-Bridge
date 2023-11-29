package bridge.request;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryRequestTest {
    @Nested
    class 성공 {

        @Nested
        class RetryRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new RetryRequest("Q"))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        class Retry_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new RetryRequest("R").toRetry())
                        .doesNotThrowAnyException();
            }
        }

    }

    @Nested
    class 예외 {
        @Nested
        class RetryRequest_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new RetryRequest("|"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("문자를 입력하지 않았습니다.");
            }
        }

        @Nested
        class Retry_Test {
            @Test
            void flow() {
                Assertions.assertThatCode(() -> new RetryRequest("A").toRetry())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Q나 R만");
            }
        }
    }
}
