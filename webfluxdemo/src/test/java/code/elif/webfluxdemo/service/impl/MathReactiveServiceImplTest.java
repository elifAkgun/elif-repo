package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.input.MultiplicationInput;
import code.elif.webfluxdemo.service.output.MultiplicationOutput;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MathReactiveServiceImplTest {

    @InjectMocks
    MathReactiveServiceImpl mathService;


    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() {
        // given- precondition or setup
        Integer expected = 25;
        // when - action or the behaviour that we are going test
        Mono<SquareOutput> actual = mathService.square(5);
        // then - verify the output
        assertThat(actual.block().getResult())
                .isEqualTo(expected);

    }

    // JUnit test for
    @Test
    public void givenNumber_whenMultiplicationTableCalled_thenReturnList() {
        // given- precondition or setup
        int number = 3;
        // when - action or the behaviour that we are going test
        Flux<MultiplicationTableOutput> multiplicationTable = mathService.getMultiplicationTable(number);

        // then - verify the output
        assertThat(multiplicationTable.next().block().getMultiplicationTableItem()).isEqualTo("3x1=3");
    }

    @Test
    public void givenMultiplicationInput_whenMultiplicationCalled_thenReturnValue() {
        // given- precondition or setup
        MultiplicationInput input = MultiplicationInput.builder()
                .number1(3)
                .number2(2)
                .build();
        // when - action or the behaviour that we are going test
        Mono<MultiplicationOutput> multiplication = mathService.getMultiplication(Mono.just(input));

        // then - verify the output
        assertThat(multiplication.block().getResult()).isEqualTo(6);
    }

}