package code.elif.repeat;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhenExceptionalDemo {

    public static void main(String[] args) throws InterruptedException {

        createOrder(Faker.instance().business().creditCardNumber())
                .retryWhen(
                        Retry.from(
                                retrySignalFlux -> retrySignalFlux
                                        .doOnNext(rs -> {
                                            System.out.println("Total Retry: " + rs.totalRetries());
                                            System.out.println("Failed: " + rs.failure().getMessage());
                                        })
                                        .handle((rs, synchronousSink) -> {
                                            if ("500".equals(rs.failure().getMessage())) {
                                                synchronousSink.next(1);
                                            } else {
                                                synchronousSink.error(rs.failure());
                                            }
                                        }).
                                        delayElements(Duration.ofSeconds(1))
                        )).
                subscribe(ReactiveStreamUtil.receiveData());

        Thread.sleep(5000);
    }


    private static Mono<String> createOrder(String creditCardNumber) {
        return Mono.fromSupplier(() -> {
            paymentService(creditCardNumber);
            return Faker.instance().idNumber().valid();
        });

    }

    private static void paymentService(String creditCardNumber) {
        int random = Faker.instance().random().nextInt(1, 10);

        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
