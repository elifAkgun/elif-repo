package code.elif.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFromFlux {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.from(Flux.just(11, 12, 13).filter(i -> i > 11));

        mono.subscribe(i -> System.out.println(i));
        mono.subscribe(i -> System.out.println(i));
        mono.subscribe(i -> System.out.println(i));
    }
}
