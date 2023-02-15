package code.elif.programatic;

import code.elif.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class FluxTakeExample {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3)
                .log()
                .subscribe(new DefaultSubscriber<>());
    }
}
