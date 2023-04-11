package code.elif.thread.multi.publishOn;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

import static code.elif.ReactiveStreamUtil.printWithThreadName;

public class PublishOnExample {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(objectFluxSink -> {
                    printWithThreadName("Flux Creating...");
                    for (int v = 0; v < 4; v++) {
                        printWithThreadName("Value Generating : " + v);
                        objectFluxSink.next(v);
                    }
                    printWithThreadName("Completing...");
                    objectFluxSink.complete();
                })
                .subscribeOn(Schedulers.boundedElastic())
                .doOnComplete(() -> printWithThreadName("Flux Completed"))
                .doOnRequest(request -> printWithThreadName("Flux Requested by " + request))
                .delayElements(Duration.ofSeconds(1))
                .share();

        System.out.println("Subscribing...");

        flux.publishOn(Schedulers.parallel())
                .subscribe(value -> printWithThreadName("First Subscriber : " + value));
        Thread.sleep(3000);
        flux.publishOn(Schedulers.immediate())
                .subscribe(value -> printWithThreadName("Second Subscriber : " + value));

        Thread.sleep(10000);
    }
}
