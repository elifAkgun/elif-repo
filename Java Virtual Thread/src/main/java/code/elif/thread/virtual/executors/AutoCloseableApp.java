package code.elif.thread.virtual.executors;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;

public class AutoCloseableApp {

    private static final Logger logger = LoggerFactory.getLogger(AutoCloseableApp.class);

    public static void main(String[] args) {
//        var executorService = Executors.newSingleThreadExecutor();
//
//        executorService.submit(AutoCloseableApp::task);
//        logger.info("Waiting for tasks to finish");
//
//        //cause to wait until executor service has no task anymore
//        executorService.shutdown();
//        // shut down executor service immediately
//        //executorService.shutdownNow();


        try (var executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(AutoCloseableApp::task);
            logger.info("Waiting for tasks to finish");
        }
    }

    private static void task() {
        CommonUtils.sleep(Duration.of(5, ChronoUnit.SECONDS));
        logger.info("task finished");
    }

}
