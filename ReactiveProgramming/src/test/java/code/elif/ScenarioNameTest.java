package code.elif;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class ScenarioNameTest {

    // JUnit test for
    @DisplayName("Scenario Name Test")
    @Test
    public void givenScenarioName_whenStepVerifierRun_thenShowScenarioName() {
        // given- precondition or setup
        Flux<String> flux = Flux.just("a","b","c","d");


        // when - action or the behaviour that we are going test
        StepVerifierOptions sampleScenario = StepVerifierOptions.create().scenarioName("sample scenario");

        // then - verify the output
        StepVerifier.create(flux,sampleScenario)
                .expectNext("a","b","c")
                .verifyComplete();
    }

    // JUnit test for
    @DisplayName("Scenario Name Test")
    @Test
    public void givenScenarioName_whenStepVerifierRun_thenShowTestName() {
        // given- precondition or setup
        Flux<String> flux = Flux.just("a","b","c1");


        // when - action or the behaviour that we are going test
        StepVerifierOptions sampleScenario = StepVerifierOptions.create().scenarioName("sample scenario");

        // then - verify the output
        StepVerifier.create(flux,sampleScenario)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("c")
                .as("c-test")
                .verifyComplete();
    }
}
