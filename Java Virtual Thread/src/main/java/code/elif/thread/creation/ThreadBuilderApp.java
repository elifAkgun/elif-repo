package code.elif.thread.creation;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.ThreadFactory;

public class ThreadBuilderApp {
    private static final Logger logger = LoggerFactory.getLogger(ThreadBuilderApp.class);

    public static void main(String[] args) {
        ThreadFactory factory = Thread.ofVirtual()
                .name("task-", 1)
                .factory();

        for (int i = 0; i < 3; i++) {
            Thread parrentThread = factory.newThread(() -> {
                logger.info("Parent task started");
                Thread childThread = factory.newThread(() -> {
                    logger.info("Child task started");
                    CommonUtils.sleep(Duration.ofSeconds(2));
                    logger.info("Child task ended");
                });
                childThread.start();
                logger.info("Parent task ended");
            });
            parrentThread.start();
        }
        CommonUtils.sleep(Duration.ofSeconds(12));
    }

}
