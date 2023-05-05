package code.elif;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class VirtualTimeTests {

    @DisplayName("test time consuming flux")
    @Test
    public void givenTimeConsumingFlux_whenStepVerifierCreateWithAwait_thenExpectElements() {
        StepVerifier.withVirtualTime(() -> timeConsumingFlux())
                .thenAwait(Duration.ofSeconds(30))
                .expectNext(1, 2, 3)
                .verifyComplete();
    }

    @DisplayName("test time consuming flux with no element")
    @Test
    public void givenTimeConsumingFlux_whenStepVerifierCreateWithAwait_thenExpectNoElements() {
        StepVerifier.withVirtualTime(() -> timeConsumingFlux())
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(3))
                .thenAwait(Duration.ofSeconds(15))
                .expectNext(1,2,3)
                .verifyComplete();
    }

    private static Flux<Integer> timeConsumingFlux() {
        return Flux.range(1, 3)
                .delayElements(Duration.ofSeconds(4));
    }
}
