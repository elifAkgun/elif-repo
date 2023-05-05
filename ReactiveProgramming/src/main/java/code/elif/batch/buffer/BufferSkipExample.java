package code.elif.batch.buffer;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BufferSkipExample {

    public static void main(String[] args) throws InterruptedException {

        getEvents().buffer(5, 8)
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(10000);
    }

    private static Flux<String> getEvents() {
        return Flux.interval(Duration.ofMillis(20))
                .map(i -> "Event" + i);
    }
}

