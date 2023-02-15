package code.elif.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.logging.Logger;

public class FluxWithIntervalExample {

    static Logger logger = Logger.getLogger(FluxWithIntervalExample.class.getName());
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(i -> logger.info("Received : " + i));

        Thread.sleep(5000);
    }
}
