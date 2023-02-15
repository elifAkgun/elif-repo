package code.elif.programatic;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxCreateWithLambdaImplementation {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String countryName;
                    do {
                        countryName = Faker.instance().country().name();
                        System.out.println("Publishing: " + countryName);
                        fluxSink.next(countryName);
                    } while (!"TURKEY".equals(countryName.toUpperCase()) && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(ReactiveStreamUtil.receiveData());
    }
}
