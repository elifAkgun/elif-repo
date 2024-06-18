package code.elif.webfluxdemo.webclient;

import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class WebClientMultipleResponseTest extends BaseTest {

    @Autowired
    private WebClient webClient;

    @Test
    void givenValidInput_whenWebClientCallsGetRequest_thenReceiveTenMultiplicationTableItems() {
        // given- precondition or setup
        String input = "5";

        // when - action or the behaviour that we are going test
        Flux<MultiplicationTableOutput> multiplicationTableOutputFlux = this.webClient.get()
                .uri("/multiplication-table-reactive/stream/{input}", input)
                .retrieve()
                .bodyToFlux(MultiplicationTableOutput.class);


        // then - verify the expected
        int itemCount = 10;
        StepVerifier.create(multiplicationTableOutputFlux)
                .expectNextCount(itemCount)
                .expectComplete()
                .verify();
    }

    @Test
    void givenInputFive_whenGetMultiplicationTableStream_thenFirstItemIsFiveTimesOne() {
        // given- precondition or setup
        String input = "5";

        // when - action or the behaviour that we are going test
        Flux<MultiplicationTableOutput> multiplicationTableOutputFlux = this.webClient.get()
                .uri("/multiplication-table-reactive/stream/{input}", input)
                .retrieve()
                .bodyToFlux(MultiplicationTableOutput.class);


        // then - verify the expected
        int itemCount = 10;
        String result = "5x1=5";
        MultiplicationTableOutput expected =
                MultiplicationTableOutput.builder()
                        .multiplicationTableItem(result).build();

        StepVerifier.create(multiplicationTableOutputFlux)
                .expectNextMatches(output -> output.equals(expected))
                .expectNextCount(itemCount - 1)
                .expectComplete()
                .verify();
    }

}
