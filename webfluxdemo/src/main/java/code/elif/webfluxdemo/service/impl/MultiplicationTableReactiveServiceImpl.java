package code.elif.webfluxdemo.service.impl;

import code.elif.webfluxdemo.service.MultiplicationTableReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@Slf4j
public class MultiplicationTableReactiveServiceImpl implements MultiplicationTableReactiveService {


    @Override
    public Flux<MultiplicationTableOutput> getMultiplicationTable(Integer number) {
        return Flux.range(1, 10).delayElements(Duration.ofSeconds(1))
                .map(i -> MultiplicationTableOutput.builder()
                        .multiplicationTableItem(String.format("%sx%s=%s", number, i, number * i)).build())
                .doOnNext(item -> log.info("on next: " + item));
    }


}
