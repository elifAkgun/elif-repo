package code.elif.flux;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FluxVsList {

    private static Logger logger = Logger.getLogger(FluxVsList.class.getName());

    public static void main(String[] args) throws InterruptedException {
//        logger.info("getAnimalsNameList started");
//        List<String> animalsName = getAnimalsNameList(3);
//        logger.info(animalsName.toString());

        logger.info("getAnimalsNameFlux started");
        Flux<String> animalsNameFlux = getAnimalsNameFlux(3);
        animalsNameFlux.subscribe(animalName -> logger.info(animalName));


    }

    private static List<String> getAnimalsNameList(int count) throws InterruptedException {
        List<String> animals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            animals.add(i, getAnimalName());
        }
        return animals;
    }

    private static Flux<String> getAnimalsNameFlux(int count) throws InterruptedException {
        return Flux.range(0, count)
                .map(i -> {
                    try {
                        return getAnimalName();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static String getAnimalName() throws InterruptedException {
        Thread.sleep(1000);
        return Faker.instance().animal().name();
    }
}
