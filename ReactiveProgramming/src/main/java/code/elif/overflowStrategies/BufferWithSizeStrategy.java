package code.elif.overflowStrategies;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class BufferWithSizeStrategy {

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
                .onBackpressureBuffer(20)
                .onErrorReturn("Error occurred!")
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    threadSleep(10);
                })
                .subscribe(i -> {
                    printWithThreadName("Received :" + i);
                });

        threadSleep(10000);
    }

    private static void threadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
