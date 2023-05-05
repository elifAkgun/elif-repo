package code.elif.combine.concat;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class ConcatDelayError {

    public static void main(String[] args) {
        Flux<Integer> integerFlux1 = Flux.just(1, 2, 3);
        Flux<Integer> integerFlux2 = Flux.error(new RuntimeException("OPS!!"));
        Flux<Integer> integerFlux3 = Flux.just(4, 5);

        Flux<Integer> concatWithFlux = Flux.concatDelayError(integerFlux1, integerFlux2, integerFlux3);
        concatWithFlux
                .onErrorReturn(-1)
                .subscribe(data -> ReactiveStreamUtil.printWithThreadName(data.toString()));
    }
}
