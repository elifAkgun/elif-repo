package code.elif.thread.virtual.executors;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;

public class AutoCloseable2App {

    private static final Logger logger = LoggerFactory.getLogger(AutoCloseable2App.class);

    public static void main(String[] args) {
        try (var executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(AutoCloseable2App::task);
            logger.info("Waiting for tasks to finish");
        }
    }

    private static void task() {
        CommonUtils.sleep(Duration.of(5, ChronoUnit.SECONDS));
        logger.info("task finished");
    }

}
