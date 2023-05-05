package code.elif.repeat;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class RepeatDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.range(1, 5);

        flux.doOnComplete(() -> System.out.println("Completed"))
                .doOnError(err -> System.out.println("Error occurred : " + err))
                .repeat(1)
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(2000);
    }
}
