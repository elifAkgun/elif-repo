package code.elif;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxBasicTests {

    @DisplayName("With stepVerifier test item match the conditions")
    @Test
    public void givenData_whenFluxCreated_thenValidateItems() {
        // given- precondition or setup
        // when - action or the behaviour that we are going test
        Flux<Integer> flux = Flux.range(1, 100);

        // then - verify the output
        StepVerifier.create(flux)
                .thenConsumeWhile(item -> item <= 100)
                .verifyComplete();
    }

    // JUnit test for range
    @DisplayName("With stepVerifier test item size")
    @Test
    public void givenData_whenFluxCreated_thenReturnExactDataSize() {
        // given- precondition or setup
        // when - action or the behaviour that we are going test
        Flux<Integer> flux = Flux.range(1, 100);

        // then - verify the output
        StepVerifier.create(flux)
                .expectNextCount(100)
                .verifyComplete();
    }

    // JUnit test for error
    @DisplayName("With stepVerifier test error")
    @Test
    public void givenFlux_whenErrorOccurred_thenVerifyError() {
        // given- precondition or setup
        Integer[] integers = {1, 2, 3};
        Flux<Integer> flux = Flux.just(integers);
        Flux<Integer> errorFlux = Flux.error(new RuntimeException("oops"));

        // when - action or the behaviour that we are going test
        Flux<Integer> concatedFlux = flux.concatWith(errorFlux);

        // then - verify the output
        StepVerifier.create(concatedFlux)
                .expectNext(1, 2, 3)
                .verifyErrorMatches(throwable ->
                        "oops".equals(throwable.getMessage()));

    }

    @DisplayName("With stepVerifier test next value")
    @Test
    public void givenData_whenFluxCreated_thenReturnExactData() {
        // given- precondition or setup
        Integer[] integers = {1, 2, 3};

        // when - action or the behaviour that we are going test
        Flux<Integer> flux = Flux.just(integers);

        // then - verify the output
        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }


}
