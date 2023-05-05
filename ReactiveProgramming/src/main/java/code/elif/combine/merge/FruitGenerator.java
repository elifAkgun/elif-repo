package code.elif.combine.merge;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FruitGenerator {

    public static Flux<String> getFruitsName() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofMillis(100))
                .map(i -> getFruit());
    }

    private static String getFruit() {
        ReactiveStreamUtil.printWithThreadName("Fruit called...");
        return Faker.instance().food().fruit();
    }
}
