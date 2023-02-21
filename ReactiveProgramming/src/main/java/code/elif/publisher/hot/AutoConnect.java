package code.elif.publisher.hot;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class AutoConnect {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> flux = Flux.fromStream(() -> getStream()).delayElements(Duration.ofMillis(1000))
                .publish()
                .autoConnect(0);

        Thread.sleep(4000);
        flux.subscribe(s -> System.out.println("-> " + "Carol" + " Received : " + s));
        Thread.sleep(2000);
        flux.subscribe(s -> System.out.println("-> " + "Daryl" + " Received : " + s));
        Thread.sleep(15000);
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
