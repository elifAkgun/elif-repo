package code.elif.programatic;

import code.elif.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class FluxPushExample {

    public static void main(String[] args) throws InterruptedException {
        CountryProducer producer = new CountryProducer();
        Flux.push(producer).subscribe(new DefaultSubscriber<>());

        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(10000);

    }
}
