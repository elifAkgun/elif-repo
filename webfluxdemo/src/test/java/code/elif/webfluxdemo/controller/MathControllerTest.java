package code.elif.webfluxdemo.controller;


import code.elif.webfluxdemo.BaseResponse;
import code.elif.webfluxdemo.service.MathService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(MathController.class)
class MathControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private MathService mathService;

    @Autowired
    ObjectMapper objectMapper;

    // JUnit test for
    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() throws Exception {
        // given- precondition or setup
        given(mathService.square(any(Integer.class)))
                .willReturn(25);

        // when - action or the behaviour that we are going test
        WebTestClient.ResponseSpec responseSpec = webTestClient.get()
                .uri("/math/square/5")
                .accept(MediaType.APPLICATION_JSON).exchange();


        // then - verify the output
        responseSpec.expectBody(BaseResponse.class)
                .value(i -> i.getData(), equalTo(25));
    }

    @Test
    public void givenNumber_whenMultiplicationTableCalled_thenReturnList() throws Exception {
        // given- precondition or setup
        given(mathService.getMultiplicationTable(any(Integer.class)))
                .willReturn(List.of("1x1=0"));

        // when - action or the behaviour that we are going test
        WebTestClient.ResponseSpec responseSpec = webTestClient.get()
                .uri("/math/multiplicationTable/5")
                .accept(MediaType.APPLICATION_JSON).exchange();


        // then - verify the output
        responseSpec.expectBody(BaseResponse.class)
                .value(i -> i.getData(), equalTo(List.of("1x1=0")));
    }



}