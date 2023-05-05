package code.elif.combine.concat;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class ConcatDemo {

    public static void main(String[] args) {
        Flux<Integer> integerFlux1 = Flux.just(1, 2, 3);
        Flux<Integer> integerFlux2 = Flux.just(4, 5);

        Flux<Integer> concatWithFlux = integerFlux1.concatWith(integerFlux2);
        concatWithFlux.subscribe(data -> ReactiveStreamUtil.printWithThreadName(data.toString()));
    }
}
