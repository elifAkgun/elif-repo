package code.elif.parallel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class ParallelRunOn {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(data -> printWithThreadName("Data : " + data));

        Thread.sleep(5000);
    }
}
