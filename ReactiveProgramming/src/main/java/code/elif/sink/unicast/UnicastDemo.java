package code.elif.sink.unicast;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class UnicastDemo {

    public static void main(String[] args) {
        Sinks.Many<Object> unicastSink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = unicastSink.asFlux();

        flux.subscribe(s -> ReactiveStreamUtil.printWithThreadName("sam: " + s));
        //  flux.subscribe(s -> ReactiveStreamUtil.printWithThreadName("mike: " + s));

        for (int i = 0; i < 4; i++) {
            unicastSink.tryEmitNext(i);
        }
    }
}
