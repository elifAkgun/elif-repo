package code.elif.overflowStrategies;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class LatestStrategy {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        printWithThreadName("Published: " + i);
                        threadSleep(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
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
