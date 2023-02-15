package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayOperatorExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("reactor.bufferSize.x", "9");
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(ReactiveStreamUtil.getConsumer());

        Thread.sleep(Duration.ofSeconds(60).toMillis());
    }
}
