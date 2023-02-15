package code.elif.programatic;

import reactor.core.publisher.Flux;

public class FluxSinkWithMultipleThread {
    public static void main(String[] args) {

        CountryProducer producer = new CountryProducer();
        Flux.create(producer).subscribe(new DefaultSubscriber<>());

        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
