package code.elif.webfluxdemo.service;

import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import reactor.core.publisher.Flux;

public interface MultiplicationTableReactiveService {
    Flux<MultiplicationTableOutput> getMultiplicationTable(Integer i);

}
