package code.elif.sink;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SinkThreadSafe {

    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<Integer> sinkMany = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Integer> flux = sinkMany.asFlux();

        List<Integer> list = new ArrayList<>();
        flux.subscribe(list::add);

//        for (int i = 0; i < 1000; i++) {
//            final int j = i;
//            CompletableFuture.runAsync(() -> sinkMany.tryEmitNext(j));
//        }

        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(() -> sinkMany.emitNext(j,
                    (signalType, emitResult) -> true));
        }

        Thread.sleep(2000);

        System.out.println("Item size: " + list.size());
    }
}
