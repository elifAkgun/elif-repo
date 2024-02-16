package code.elif.webfluxdemo.controller;

import code.elif.webfluxdemo.controller.api.CalculationController;
import code.elif.webfluxdemo.controller.response.FailedResponse;
import code.elif.webfluxdemo.service.impl.CalculationReactiveServiceImpl;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(CalculationController.class)
class CalculationControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CalculationReactiveServiceImpl calculationService;

    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() {
        int input = 5;
        SquareOutput expected = SquareOutput.builder().result(25).build();
        given(calculationService.square(input))
                .willReturn(Mono.just(expected));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/calculator/square/" + input)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                // then - verify the output
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody(SquareOutput.class)
                .isEqualTo(expected);
    }

    @Test
    public void givenNumberMoreThan20_whenSquareCalled_thenReturnException() {
        int input = 21;
        SquareOutput output = SquareOutput.builder().result(25).build();
        given(calculationService.square(input))
                .willReturn(Mono.just(output));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/calculator/square/" + input)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                // then - verify the output
                .expectStatus().isBadRequest()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody(FailedResponse.class);
    }
    @Test
    public void givenNumbers_whenMultiplicationCalled_thenReturnValue() {
        // given
        CalculationOutput expected = CalculationOutput.builder()
                .result(BigDecimal.valueOf(6))
                .build();

        CalculationInput input = CalculationInput.builder()
                .number1(BigDecimal.valueOf(2))
                .number2(BigDecimal.valueOf(3))
                .build();

        given(calculationService.multiplication(any(Mono.class)))
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
