package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class MathReactiveServiceImpl implements MathReactiveService {

    @Override
    public Flux<MultiplicationTableOutput> getMultiplicationTable(Integer number) {
        return Flux.range(1, 10).delayElements(Duration.ofSeconds(1))
                .map(i -> MultiplicationTableOutput.builder()
                        .multiplicationTableItem(String.format("%sx%s=%s", number, i, number * i)).build())
                .doOnNext(item -> System.out.println("on next: " + item));
    }


}
