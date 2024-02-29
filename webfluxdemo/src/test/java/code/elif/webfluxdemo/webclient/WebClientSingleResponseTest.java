package code.elif.webfluxdemo.webclient;

import code.elif.webfluxdemo.service.output.SquareOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class WebClientSingleResponseTest extends BaseTest {

    @Autowired
    private WebClient webClient;

    @Test
    void givenValidInput_whenWebClientCallGetRequest_thenGetResult2() {
        // given- precondition or setup
        String input = "5";

        // when - action or the behaviour that we are going test
        Mono<SquareOutput> squareOutputMono = this.webClient.get()
                .uri("/reactive-calculator/square/{number}", input)
                .retrieve()
                .bodyToMono(SquareOutput.class);


        // then - verify the output
        StepVerifier.create(squareOutputMono)
                .expectNextMatches(squareOutput -> squareOutput.getResult().equals(25))
                .expectComplete()
                .verify();
    }

}
