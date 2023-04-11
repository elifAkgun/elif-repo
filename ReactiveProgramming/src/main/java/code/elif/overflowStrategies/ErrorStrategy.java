package code.elif.overflowStrategies;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class ErrorStrategy {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        printWithThreadName("Published: " + i);
                        threadSleep(1);

                    }
                    fluxSink.complete();
                })
                .onBackpressureError()
                .onBackpressureDrop(t-> System.out.println(t))
                .publishOn(Schedulers.boundedElastic())
                .doOnError(throwable -> System.out.println(throwable.getMessage()))
                .doOnNext(i -> {
                    threadSleep(5);
                })
                .subscribe(i -> {
                    printWithThreadName("Received :" + i);
                });

        threadSleep(5000);
    }

    private static void threadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
