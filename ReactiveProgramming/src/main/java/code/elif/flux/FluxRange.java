package code.elif.flux;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {
        Flux.range(3, 5)
                .log()
                .map(i -> Faker.instance().animal().name())
                .log()
                .subscribe(ReactiveStreamUtil.getConsumer());
    }
}
