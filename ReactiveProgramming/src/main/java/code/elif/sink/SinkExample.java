package code.elif.sink;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkExample {

    public static void main(String[] args) {

        Sinks.One<Object> one = Sinks.one();

        Mono<Object> objectMono = one.asMono();

        objectMono.subscribe(ReactiveStreamUtil.receiveData());

        one.tryEmitValue("Hello!!");

    }
}
