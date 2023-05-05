package code.elif.combine.latest;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombineLatestDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> stringFlux = Flux.just("a", "b", "c", "d")
                .delayElements(Duration.ofMillis(500));

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6)
                .delayElements(Duration.ofMillis(1500));


        Flux.combineLatest(stringFlux, integerFlux, (s, i) -> s + i)
                .subscribe(ReactiveStreamUtil.receiveData());


        Thread.sleep(5000);
    }
}
