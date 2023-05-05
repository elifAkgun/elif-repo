package code.elif.repeat;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhenDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.range(1, 10)
                .map(i -> i < 5 ? i : i / 0);

        flux.doOnComplete(() -> System.out.println("Completed"))
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(1)))
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(6000);
    }
}
