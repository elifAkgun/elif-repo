package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    CalculationReactiveServiceImpl calculationService;


    @Test
    public void givenMultiplicationInput_whenMultiplicationCalled_thenReturnValue() {
        // given- precondition or setup
        CalculationInput input = CalculationInput.builder()
                .number1(BigDecimal.valueOf(2))
                .number2(BigDecimal.valueOf(3))
                .build();
        // when - action or the behaviour that we are going test
        Mono<CalculationOutput> multiplication = calculationService.multiplication(Mono.just(input));

        // then - verify the output
        assertThat(multiplication.block().getResult()).isEqualTo(BigDecimal.valueOf(6));
    }
    @Test
    public void givenNumber_whenSquareCalled_thenReturnCorrectNumber() {
        // given- precondition or setup
        Integer expected = 25;
        // when - action or the behaviour that we are going test
        Mono<SquareOutput> actual = calculationService.square(5);
        // then - verify the output
        assertThat(actual.block().getResult())
                .isEqualTo(expected);

    }
}