package code.elif.publisher.cold;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class ColdPublisher {
    public static void main(String[] args) throws InterruptedException {

        Flux<String> flux = Flux.fromStream(() -> getStream()).delayElements(Duration.ofMillis(1000));

        flux.subscribe(s -> System.out.println("-> " + "Carol" + " Received : " + s));
        Thread.sleep(3000);
        flux.subscribe(s -> System.out.println("-> " + "Daryl" + " Received : " + s));
        Thread.sleep(10000);
    }

    private static Stream<String> getStream() {
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
