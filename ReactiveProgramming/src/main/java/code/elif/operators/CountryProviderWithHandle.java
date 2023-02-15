package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class CountryProviderWithHandle {
    public static void main(String[] args) {
        Flux.generate(synchronousSink ->
                        synchronousSink.next(Faker.instance().country().name()))
                .handle((item, synchronousSink) -> {
                    synchronousSink.next(item);
                    if ("TURKEY".equals(item.toString().toUpperCase())) {
                        synchronousSink.complete();
                    }
                }).subscribe(ReactiveStreamUtil.receiveData());
    }
}
