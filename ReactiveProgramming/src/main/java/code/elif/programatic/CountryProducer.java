package code.elif.programatic;

import com.github.javafaker.Faker;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class CountryProducer implements Consumer<FluxSink<String>> {
    FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public void produce() {
        String threadName = Thread.currentThread().getName();
        fluxSink.next(threadName + " : " + Faker.instance().country().name());
    }
}
