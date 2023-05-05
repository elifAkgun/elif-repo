package code.elif.combine.merge;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class VegetableGenerator {

    public static Flux<String> getVegetableNames() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofMillis(200))
                .map(i -> getVegetable());
    }

    private static String getVegetable() {
        ReactiveStreamUtil.printWithThreadName("Vegetable called...");
        return Faker.instance().food().vegetable();
    }
}
