package code.elif.programatic;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class FluxGenerateExample {

    public static void main(String[] args) {
        //    counterOutSideOfMethod();
        //fluxGenerateExample();

        Flux<String> flux = Flux.generate(
                () -> 1,
                (counter, stringSynchronousSink) -> {
                    String countryName = Faker.instance().country().name();
                    System.out.println("Emitting : " + countryName);
                    stringSynchronousSink.next(countryName);
                    if ("TURKEY".equals(countryName.toUpperCase()) || counter != 3) {
                        stringSynchronousSink.complete();
                    }
                    return counter + 1;
                }
        );
        flux.subscribe(ReactiveStreamUtil.receiveData());
    }

    private static void fluxGenerateExample() {
        Flux<String> fluxCountry = Flux.generate(
                stringSynchronousSink -> {
                    String countryName = Faker.instance().country().name();
                    System.out.println("Emitting : " + countryName);
                    stringSynchronousSink.next(countryName);
                    if ("TURKEY".equals(countryName.toUpperCase()))
                        stringSynchronousSink.complete();
                });

        fluxCountry.subscribe(ReactiveStreamUtil.receiveData());
    }

    private static void counterOutSideOfMethod() {
        AtomicReference<Integer> count = new AtomicReference<>(0);
        Flux<String> fluxCountry = Flux.generate(
                stringSynchronousSink -> {
                    count.set(count.get() + 1);
                    String countryName = Faker.instance().country().name();
                    System.out.println("Emitting : " + countryName);
                    stringSynchronousSink.next(countryName);
                    if ("TURKEY".equals(countryName.toUpperCase()) || count.get().intValue() == 3)
                        stringSynchronousSink.complete();
                });

        fluxCountry.subscribe(ReactiveStreamUtil.receiveData());
    }
}
