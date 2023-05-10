package code.elif.webfluxdemo.controller;

import code.elif.webfluxdemo.controller.api.CalculationController;
import code.elif.webfluxdemo.service.impl.CalculationReactiveServiceImpl;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(CalculationController.class)
class CalculationControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CalculationReactiveServiceImpl calculationReactiveService;

    @Test
    public void givenNumbers_whenMultiplicationCalled_thenReturnValue() {
        // given
        CalculationOutput expected = CalculationOutput.builder()
                .result(6)
                .build();

        CalculationInput input = CalculationInput.builder()
                .number1(2)
                .number2(3)
                .build();

        given(calculationReactiveService.multiplication(any(Mono.class)))
                .willReturn(Mono.just(expected));

        // when
        FluxExchangeResult<CalculationOutput> result = webTestClient.post()
                .uri("/calculator/multiplication")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(input)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(CalculationOutput.class);

        // then
        StepVerifier.create(result.getResponseBody())
                .expectNext(expected)
                .expectComplete()
                .verify();
    }
}
