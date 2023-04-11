package code.elif.thread.multi.subscireOn;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class MultiThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(
                        integerFluxSink -> {
                            printWithThreadName("Create");
                            integerFluxSink.next(1);
                        })
                .doOnNext(i -> printWithThreadName("Next"));

        Runnable runnable = () ->
                flux.doFirst(() -> printWithThreadName("First - 1"))
                        .subscribeOn(Schedulers.boundedElastic())
                        .doFirst(() -> printWithThreadName("First - 2"))
                        .subscribe(v -> printWithThreadName("Sub : " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(5000);
    }


}
