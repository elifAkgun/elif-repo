package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
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

}