package code.elif.flux;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class FluxStockExample {

    public static void main(String[] args) {
        Flux<Integer> stockPrice = getStockPrice();
        AtomicReference<Integer> price = new AtomicReference<>();
        AtomicReference<Subscription> subscription = new AtomicReference<>();
        stockPrice.subscribe(new Subscriber<>() {

            @Override
            public void onSubscribe(Subscription s) {
                subscription.set(s);
            }

            @Override
            public void onNext(Integer integer) {
                price.set(integer);
                System.out.println("Stock is : " + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println(t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Stock observing is completed");
            }
        });

        while (price.get() == null || price.get().compareTo(-100) > 0 && price.get().compareTo(100) < 0) {
            subscription.get().request(1);
        }
        subscription.get().cancel();
    }

    private static Flux<Integer> getStockPrice() {
        AtomicReference<Integer> integerAtomicReference = new AtomicReference<>(0);
        return Flux.interval(Duration.ofMillis(10))
                .map(i -> integerAtomicReference.getAndAccumulate(calculateStockChange(),
                        Integer::sum));
    }

    private static Integer calculateStockChange() {
        return Faker.instance().random().nextInt(-5,5);
    }
}
