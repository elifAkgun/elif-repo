package code.elif.flux;

import code.elif.ReactiveStreamUtil;
import jdk.jshell.execution.Util;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class FluxFromStream {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Flux<Integer> numbers = Flux.fromStream(integerStream);
        numbers.subscribe(ReactiveStreamUtil.getConsumer());
        numbers.subscribe(ReactiveStreamUtil.getConsumer());
    }
}
