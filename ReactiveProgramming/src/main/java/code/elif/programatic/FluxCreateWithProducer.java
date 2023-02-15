package code.elif.programatic;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class FluxCreateWithProducer {

    public static void main(String[] args) {
        CountryProducer countryProducer = new CountryProducer();
        Flux.create(countryProducer)
                .subscribe(ReactiveStreamUtil.receiveData());

        countryProducer.produce();
    }
}
