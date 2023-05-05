package code.elif.repeat;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class RetryDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.range(1, 10)
                .map(i -> i < 5 ? i : i / 0);

        flux.doOnComplete(() -> System.out.println("Completed"))
                .retry(1)
                .doOnError(err -> System.out.println("Error occurred : " + err))
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(2000);
    }
}
