package code.elif.thread.virtual.executors;

import code.elif.util.CommonUtils;
import code.elif.util.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsTypesApp {

    public static final int THREADS = 5;
    public static final int INTENSIVE = 1000;

    private static final Logger logger = LoggerFactory.getLogger(ExecutorsTypesApp.class);

    public static void main(String[] args) {
        // execute(Executors.newSingleThreadExecutor(), 7);
        // execute(Executors.newFixedThreadPool(THREADS), 5);
        // execute(Executors.newCachedThreadPool(), 200);
        // execute(Executors.newVirtualThreadPerTaskExecutor(),200);
        // execute(Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory()), 100);
        scheduled();
    }

    private static void scheduled() {
        try (var executor = Executors.newSingleThreadScheduledExecutor()) {
            executor.scheduleWithFixedDelay(() -> logger.info("Executing tasks...")
                    , 0, 1, TimeUnit.SECONDS);

            CommonUtils.sleep(Duration.of(5, ChronoUnit.SECONDS));
        }
    }

    private static void execute(ExecutorService executorService, int taskCount) {

        try (executorService) {
            for (int i = 0; i < taskCount; i++) {
                int finalI = i;
                executorService.submit(() ->
                        Tasks.ioIntensive(INTENSIVE, "ExecutorService" + finalI));
            }
            logger.info("Submitted tasks");
        }
    }

}
