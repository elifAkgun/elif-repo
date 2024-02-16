package code.elif.webfluxdemo.service;

import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import reactor.core.publisher.Mono;

public interface CalculationService {

    Mono<CalculationOutput> addition(Mono<CalculationInput> input);
    Mono<CalculationOutput> subtraction(Mono<CalculationInput> input);
    Mono<CalculationOutput> multiplication(Mono<CalculationInput> input);
    Mono<CalculationOutput> division(Mono<CalculationInput> input);
    Mono<SquareOutput> square(Integer i);

}
