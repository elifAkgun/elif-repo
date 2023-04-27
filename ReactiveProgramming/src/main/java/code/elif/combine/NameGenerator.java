package code.elif.combine;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> cachedNames = new ArrayList<>();

    public Flux<String> getCityName(String subscriberName) {

        System.out.println(subscriberName + " wants to data...");
        return Flux.generate(fluxSink -> {
                            createLatency(fluxSink);
                            String cityName = getCityName();
                            fluxSink.next(cityName);
                        }
                ).cast(String.class)
                .startWith(getFromCache());
    }

    private String getCityName() {
        String cityName = Faker.instance().address().cityName();
        cachedNames.add(cityName);
        return cityName;
    }

    private static void createLatency(SynchronousSink<Object> fluxSink) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            fluxSink.error(new RuntimeException(e));
        }
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(cachedNames);
    }
}
