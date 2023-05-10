package code.elif.webfluxdemo.service;

import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MathReactiveService {
    Mono<SquareOutput> square(Integer i);

    Flux<MultiplicationTableOutput> getMultiplicationTable(Integer i);


}
