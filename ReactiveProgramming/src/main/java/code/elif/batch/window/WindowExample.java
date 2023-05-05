package code.elif.batch.window;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class WindowExample {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> animal = getAnimal();

        animal.window(5)
                .subscribe(flux -> {
                    ReactiveStreamUtil.printWithThreadName("Flux received...");
                    flux.subscribe(a -> ReactiveStreamUtil.printWithThreadName(a));
                });


        Thread.sleep(10000);
    }

    private static Flux<String> getAnimal() {
        return Flux.range(1, 10)
                .map(i -> Faker.instance().animal().name())
                .delayElements(Duration.ofSeconds(1));
    }
}
