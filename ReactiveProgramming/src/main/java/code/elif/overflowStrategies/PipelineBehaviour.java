package code.elif.overflowStrategies;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class PipelineBehaviour {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        printWithThreadName("Published: " + i);
                    }
                    fluxSink.complete();
                }).publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    threadSleepSeconds(1);
                })
                .subscribe(i -> printWithThreadName("Received :" + i));

        threadSleepSeconds(15);
    }

    private static void threadSleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
