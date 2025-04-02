package code.elif.thread.virtual.schedular;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CooperativeSchedulingApp {

    private static final Logger logger = LoggerFactory.getLogger(CooperativeSchedulingApp.class);

    //for demonstrating limited resource
    static {
        System.setProperty("jdk.virtualThreadScheduler.parallelism", "1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
    }

    public static void main(String[] args) {
        var builder = Thread.ofVirtual();
        Thread unstartedThread = builder.unstarted(() -> cooperativeSchedulingApp(1));
        unstartedThread.start();
        Thread unstartedThread2 = builder.unstarted(() -> cooperativeSchedulingApp(2));
        unstartedThread2.start();


        CommonUtils.sleep(Duration.ofSeconds(2));
    }

    public static void cooperativeSchedulingApp(int threadCount) {
        logger.info("Starting cooperative scheduling app with thread count {}", threadCount);
        for (int i = 0; i < 10; i++) {
            logger.info("thread - {} is printing {}. Thread name : {}", threadCount, i, Thread.currentThread());
            Thread.yield();
        }

        logger.info("Finished cooperative scheduling app with thread count {}", threadCount);
    }
}
