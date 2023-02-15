package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class TimeOutExample {

    public static void main(String[] args) throws InterruptedException {
        getAnimalName()
                .log()
                .timeout(ofSeconds(2), fallbackAnimal())
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }

    private static Flux<Object> getAnimalName() {
        return Flux.generate(synchronousSink -> {
            synchronousSink.next(Faker.instance().animal().name());
        }).delayElements(ofSeconds(5));
    }

    private static Flux<Object> fallbackAnimal() {
        return Flux.generate(synchronousSink -> {
            synchronousSink.next(Faker.instance().animal().name());
        }).delayElements(ofMillis(200));
    }
}
