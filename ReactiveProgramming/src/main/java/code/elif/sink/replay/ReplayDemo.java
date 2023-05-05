package code.elif.sink.replay;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class ReplayDemo {

    public static void main(String[] args) {
        Sinks.Many<Object> unicastSink = Sinks.many().replay().all();

        Flux<Object> flux = unicastSink.asFlux();

        flux.subscribe(s -> ReactiveStreamUtil.printWithThreadName("sam: " + s));

        unicastSink.tryEmitNext(1);
        unicastSink.tryEmitNext(2);
        unicastSink.tryEmitNext(3);
        flux.subscribe(s -> ReactiveStreamUtil.printWithThreadName("mike: " + s));
        unicastSink.tryEmitNext(4);
    }
}
