package code.elif.webfluxdemo.service;

import code.elif.webfluxdemo.service.input.MultiplicationInput;
import code.elif.webfluxdemo.service.output.MultiplicationOutput;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MathReactiveService {
    Mono<SquareOutput> square(Integer i);

    Flux<MultiplicationTableOutput> getMultiplicationTable(Integer i);

    Mono<MultiplicationOutput> getMultiplication(Mono<MultiplicationInput> input);
}
