package code.elif.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    public static void main(String[] args) throws InterruptedException {
        Mono.fromFuture(getAnimalName())
                .subscribe(s -> System.out.println(s));

        Thread.sleep(1000);
    }

    private static CompletableFuture<String> getAnimalName() {
        return CompletableFuture.supplyAsync(() -> Faker.instance().animal().name());
    }
}
