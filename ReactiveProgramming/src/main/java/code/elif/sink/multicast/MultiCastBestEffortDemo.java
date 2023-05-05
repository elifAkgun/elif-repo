package code.elif.sink.multicast;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class MultiCastBestEffortDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("reactor.bufferSize.x", "8");
        Sinks.Many<Object> unicastSink = Sinks.many().multicast().directBestEffort();

        Flux<Object> flux = unicastSink.asFlux();

        flux.subscribe(s -> ReactiveStreamUtil.printWithThreadName("sam: " + s));
        flux.delayElements(Duration.ofMillis(200))
                .subscribe(s -> ReactiveStreamUtil.printWithThreadName("mike: " + s));

        for (int i = 0; i < 100; i++) {
            unicastSink.tryEmitNext(i);
        }

        Thread.sleep(10000);
    }
}
