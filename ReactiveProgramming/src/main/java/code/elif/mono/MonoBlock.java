package code.elif.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoBlock {
    public static void main(String[] args) {
        String animalName = getAnimalName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(animalName);
    }

    private static Mono<String> getAnimalName() {
        System.out.println("Animal name calculating...");
        return Mono.fromSupplier(() -> {
            System.out.println("Animal is generating...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Faker.instance().animal().name();
        });
    }
}
