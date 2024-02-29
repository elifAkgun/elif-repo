package code.elif.webfluxdemo.controller;


import code.elif.webfluxdemo.controller.api.MultiplicationTableReactiveController;
import code.elif.webfluxdemo.service.MultiplicationTableReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(MultiplicationTableReactiveController.class)
class MultiplicationTableReactiveControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MultiplicationTableReactiveService multiplicationTableReactiveService;


    @Test
    void givenNumber_whenGetMultiplicationTableCalled_thenReturnMultiplicationTable() {
        // given- precondition or setup
        given(multiplicationTableReactiveService.getMultiplicationTable(any(Integer.class)))
                .willReturn(Flux.just(MultiplicationTableOutput.builder().multiplicationTableItem("1 x 1 = 1").build(),
                        MultiplicationTableOutput.builder().multiplicationTableItem("1 x 2 = 2").build()));

        // when - action or the behaviour that we are going test
        webTestClient.get()
                .uri("/multiplication-table-reactive/1")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()

                // then - verify the output
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
                .expectBodyList(MultiplicationTableOutput.class)
                .hasSize(2);
    }

}
