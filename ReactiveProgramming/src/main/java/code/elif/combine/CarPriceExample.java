package code.elif.combine;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CarPriceExample {

    public static void main(String[] args) throws InterruptedException {
        Flux<Double> demand = Flux.interval(Duration.ZERO,
                        Duration.ofSeconds(3))
                .map(i -> Faker.instance().random().nextInt(8, 12) / 10d)
                .startWith(1d);


        Flux<Long> month = Flux.interval(Duration.ZERO, Duration.ofSeconds(1));

        final int carPrice = 10000;
        Flux.combineLatest(month, demand, (m, d) ->
                        (carPrice - (m * 100)) * d)
                .subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(10000);
    }


}
