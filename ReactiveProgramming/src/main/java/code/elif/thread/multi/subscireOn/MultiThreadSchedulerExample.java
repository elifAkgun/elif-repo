package code.elif.thread.multi.subscireOn;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class MultiThreadSchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(integerFluxSink -> {
                    printWithThreadName("Flux Created ->");
                    for (int i = 0; i < 5; i++) {
                        integerFluxSink.next(i);
                    }
                    integerFluxSink.complete();
                }).doOnNext(i -> printWithThreadName("Publishing ->" + i))
                .doOnComplete(() -> printWithThreadName("Completed"))
                .subscribeOn(Schedulers.boundedElastic());

        Runnable runnable1 = () ->
                flux.doFirst(() -> printWithThreadName("First - 1"))
                        .subscribeOn(Schedulers.parallel())
                        .doFirst(() -> printWithThreadName("First - 2"))
                        .subscribe(value -> printWithThreadName("Sub : " + value));

        Runnable runnable2 = () -> flux
                .doFirst(() -> printWithThreadName("First - 1"))
                .subscribeOn(Schedulers.immediate())
                .doFirst(() -> printWithThreadName("First - 2"))
                .subscribe(value -> printWithThreadName("Sub : " + value));

        Thread.sleep(1000);

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        Thread.sleep(5000);
    }
}
