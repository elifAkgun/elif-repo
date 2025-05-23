package code.elif.thread.virtual;

import code.elif.util.CommonUtils;
import code.elif.util.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CPUTaskDemo {

    public static final int TASK_COUNT = 1;
    private static final Logger logger = LoggerFactory.getLogger(CPUTaskDemo.class);

    public static void main(String[] args) {
        logger.info("Starting CPU Task Demo : TASK COUNT: " + TASK_COUNT);

        for (int i = 0; i < 3; i++) {
            long timerOfVirtualThread = CommonUtils.timer(() -> demo(Thread.ofVirtual()));
            logger.info("Total time for virtual thread: {}", timerOfVirtualThread);
            long timerOfPlatformThread = CommonUtils.timer(() -> demo(Thread.ofPlatform()));
            logger.info("Total time for platform thread: {}", timerOfPlatformThread);
        }

    }

    private static void demo(Thread.Builder builder) {
        CountDownLatch countDownLatch = new CountDownLatch(TASK_COUNT);
        for (int i = 0; i < TASK_COUNT; i++) {
            builder.start(() -> {
                Tasks.cpuIntensive(45);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
