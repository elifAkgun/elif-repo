package code.elif.combine.zip;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class ZipDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6)
                .delayElements(Duration.ofMillis(500));

        Flux<String> stringFlux = Flux.just("a", "b", "c", "d")
                .delayElements(Duration.ofMillis(1000));

        Flux<String> stringFlux2 = Flux.just("1", "2", "3")
                .delayElements(Duration.ofMillis(250));


        Flux.zip(integerFlux, stringFlux, stringFlux2)
                .subscribe(ReactiveStreamUtil.receiveData());


        Thread.sleep(5000);
    }
}
