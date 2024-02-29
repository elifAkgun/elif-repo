package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.exception.InputValidationException;
import code.elif.webfluxdemo.service.CalculationReactiveService;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

@Service
public class CalculationReactiveReactiveServiceImpl implements CalculationReactiveService {

    @Override
    public Mono<CalculationOutput> addition(Mono<CalculationInput> input) {
        return input.map(numbers -> process(numbers, (a, b) ->
                CalculationOutput.builder().result(a.add(b)).build()));
    }

    @Override
    public Mono<CalculationOutput> subtraction(Mono<CalculationInput> input) {
        return input.map(numbers -> process(numbers, (a, b) ->
                CalculationOutput.builder().result(a.subtract(b)).build()));
    }

    @Override
    public Mono<CalculationOutput> multiplication(Mono<CalculationInput> input) {
        return input.map(numbers -> process(numbers, (a, b) ->
                CalculationOutput.builder().result(a.multiply(b)).build()));
    }

    @Override
    public Mono<CalculationOutput> division(Mono<CalculationInput> input) {
        return input
                .handle((numbers, sink) -> {
                    if (BigDecimal.ZERO.equals(numbers.getNumber1())) {
                        sink.error(new InputValidationException(numbers.getNumber1(), "Illegal number1 parameter"));
                    } else {
                        sink.next(process(numbers, (a, b) ->
                                CalculationOutput.builder().result(a.divide(b, RoundingMode.DOWN)).build()));
                    }
                });
    }

    @Override
    public Mono<SquareOutput> square(Integer number) {
        return Mono.just(SquareOutput.builder()
                .result(number * number).build());
    }

    private CalculationOutput process(CalculationInput input,
                                      BiFunction<BigDecimal, BigDecimal, CalculationOutput> opLogic) {
        return opLogic.apply(input.getNumber1(), input.getNumber2());
    }
}
