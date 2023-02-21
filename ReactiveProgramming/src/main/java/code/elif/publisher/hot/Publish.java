package code.elif.publisher.hot;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Publish {
    public static void main(String[] args) throws InterruptedException {

        Flux<String> flux = Flux.fromStream(() -> getStream())
                .delayElements(Duration.ofMillis(1000))
                .publish()
                .refCount(2);

        flux.subscribe(s -> System.out.println("-> " + "Carol" + " Received : " + s));
        System.out.println("Subscriber-1 connected..");
        Thread.sleep(3000);

        flux.subscribe(s -> System.out.println("-> " + "Daryl" + " Received : " + s));
        System.out.println("Subscriber-2 connected..");
        Thread.sleep(10000);
    }

    private static Stream<String> getStream() {
        System.out.println("Stream is getting...");
        Stream<String> stream = Stream.of("Stream-1",
                "Stream-2",
                "Stream-3",
                "Stream-4",
                "Stream-5",
                "Stream-6"
        );
        return stream;
    }
}
