package code.elif.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {
        Flux<String> flux = Mono.just("Apple").flux();
        flux.subscribe(fruit -> System.out.println(fruit));
    }
}
