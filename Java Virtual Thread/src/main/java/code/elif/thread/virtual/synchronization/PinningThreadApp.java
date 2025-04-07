package code.elif.thread.virtual.synchronization;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class PinningThreadApp {

    private static final Logger logger = LoggerFactory.getLogger(PinningThreadApp.class);

    static {
        System.setProperty("jdk.tracePinnedThreads", "full");
    }

    public static void main(String[] args) {

        Runnable runnable = () -> logger.info("Pinned Thread is blocking me!!");
        demo(Thread.ofVirtual());
        Thread.ofVirtual().start(runnable);
        CommonUtils.sleep(Duration.ofSeconds(20));
    }

    public static void demo(Thread.Builder threadBuilder) {
        for (int i = 0; i < 100; i++) {
            threadBuilder.start(() -> {
                logger.info("IO tasks are started...");
                ioTask();
                logger.info("IO tasks are finished...");
            });
        }
    }

    private static synchronized void ioTask() {
        CommonUtils.sleep(Duration.ofSeconds(1000));
    }
}
