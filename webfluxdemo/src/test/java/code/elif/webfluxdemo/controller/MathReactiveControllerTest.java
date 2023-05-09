package code.elif.webfluxdemo.controller;


import code.elif.webfluxdemo.controller.response.FailedResponse;
import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.input.MultiplicationInput;
import code.elif.webfluxdemo.service.output.MultiplicationOutput;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(MathReactiveController.class)
public class MathReactiveControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MathReactiveService mathReactiveService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() {
        int input = 5;
        SquareOutput expected = SquareOutput.builder().result(25).build();
        given(mathReactiveService.square(input))
                .willReturn(Mono.just(expected));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/math-reactive/square/" + input)
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
        given(mathReactiveService.square(input))
                .willReturn(Mono.just(output));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/math-reactive/square/" + input)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                // then - verify the output
                .expectStatus().isBadRequest()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody(FailedResponse.class);
    }

    @Test
    public void givenNumber_whenGetMultiplicationTableCalled_thenReturnMultiplicationTable() {
        // given- precondition or setup
        given(mathReactiveService.getMultiplicationTable(any(Integer.class)))
                .willReturn(Flux.just(MultiplicationTableOutput.builder().multiplicationTableItem("1 x 1 = 1").build(),
                        MultiplicationTableOutput.builder().multiplicationTableItem("1 x 2 = 2").build()));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/math-reactive/multiplicationTable/1")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()

                // then - verify the output
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
                .expectBodyList(MultiplicationTableOutput.class)
                .hasSize(2);
    }

    @Test
    public void givenNumbers_whenMultiplicationCalled_thenReturnValue() {
        // given
        MultiplicationOutput expected = MultiplicationOutput.builder()
                .result(6)
                .build();

        MultiplicationInput input = MultiplicationInput.builder()
                .number1(2)
                .number2(3)
                .build();

        given(mathReactiveService.getMultiplication(any(Mono.class)))
                .willReturn(Mono.just(expected));

        // when
        FluxExchangeResult<MultiplicationOutput> result = webTestClient.post()
                .uri("/math-reactive/multiplication")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(input)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(MultiplicationOutput.class);

        // then
        StepVerifier.create(result.getResponseBody())
                .expectNext(expected)
                .expectComplete()
                .verify();
    }

}