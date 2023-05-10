package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.CalculationService;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CalculationReactiveServiceImpl implements CalculationService {

    @Override
    public Mono<CalculationOutput> addition(Mono<CalculationInput> input) {
        return input
                .map(numbers -> numbers.getNumber1() + numbers.getNumber2())
                .map(CalculationOutput::new);
    }

    @Override
    public Mono<CalculationOutput> subtraction(Mono<CalculationInput> input) {
        return input
                .map(numbers -> numbers.getNumber1() - numbers.getNumber2())
                .map(CalculationOutput::new);
    }

    @Override
    public Mono<CalculationOutput> multiplication(Mono<CalculationInput> input) {
        return input
                .map(numbers -> numbers.getNumber1() * numbers.getNumber2())
                .map(CalculationOutput::new);
    }
    @Override
    public Mono<CalculationOutput> division(Mono<CalculationInput> input) {
        return input
                .map(numbers -> numbers.getNumber1() / numbers.getNumber2())
                .map(CalculationOutput::new);
    }
}
