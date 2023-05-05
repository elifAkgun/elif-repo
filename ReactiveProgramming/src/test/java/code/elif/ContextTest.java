package code.elif;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class ContextTest {

    // JUnit test for
    @DisplayName("Test Context UserId")
    @Test
    public void givenContext_when_thenValidateKey() {
        // given- precondition or setup
        StepVerifierOptions stepVerifierOptions = StepVerifierOptions.create().withInitialContext(Context.of("userId", "sasha"));

        // when - action or the behaviour that we are going test
        StepVerifier.Step<String> helloSasha = StepVerifier.create(getWelcomeMessage(), stepVerifierOptions);


        // then - verify the output
        helloSasha.expectNext("Hello sasha")
                .verifyComplete();
    }


    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(contextView ->
                contextView.hasKey("userId") ? Mono.just("Hello " + contextView.get("userId"))
                        : Mono.error(new RuntimeException("UnAuthentication user!"))
        );
    }
}
