package code.elif.webfluxdemo.controller;

import code.elif.webfluxdemo.config.CalculatorRequestHandler;
import code.elif.webfluxdemo.config.CalculatorRouterConfig;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(CalculatorRouterConfig.class)
class CalculationReactiveRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CalculatorRequestHandler  calculatorRequestHandler;

    @Test
    public void givenNumbers_whenMultiplicationCalled_thenReturnValue() {
        // given
        CalculationOutput output = CalculationOutput.builder()
                .result(6)
                .build();

        Mono<ServerResponse> expected = ServerResponse.ok()
                .bodyValue(output);

        CalculationInput input = CalculationInput.builder()
                .number1(2)
                .number2(3)
                .build();

        given(calculatorRequestHandler.getMultiplication(any(ServerRequest.class)))
                .willReturn(expected);

        // when
        FluxExchangeResult<CalculationOutput> result = webTestClient.post()
                .uri("/router/calculator/multiplication")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(input)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(CalculationOutput.class);

        // then
        StepVerifier.create(result.getResponseBody())
                .expectNext(output)
                .expectComplete()
                .verify();
    }
}
