package code.elif.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class MonoFromSupplier {

    public static void main(String[] args) {
        //  Mono<String> mono = Mono.just(getAnimal());

        Mono<String> fromSupplier = Mono.fromCallable(MonoFromSupplier::getAnimal);
        fromSupplier.subscribe(
                getStringConsumer(),
                getThrowableConsumer(),
                getCompleted()
        );

    }

    private static Runnable getCompleted() {
        return () -> System.out.println("Completed");
    }

    private static Consumer<Throwable> getThrowableConsumer() {
        return error -> System.out.print("Error: " + error.getMessage());
    }

    private static Consumer<String> getStringConsumer() {
        return s -> System.out.println(s);
    }

    private static String getAnimal() {
        System.out.println("Generating Animal....");
        return Faker.instance().animal().name();
    }
}
