package code.elif.thread.virtual.synchronization;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class IOReentrantLockApp {

    private static final Logger logger = LoggerFactory.getLogger(IOReentrantLockApp.class);
    private static final Lock lock = new ReentrantLock(); // Fairness varsayılan olarak false

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
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            threadBuilder.start(() -> {
                logger.info("{}. IO task is started...", finalI);
                ioTask();
                logger.info("{}. IO tasks is finished...", finalI);
            });
        }
    }

    private static void ioTask() {
        try {
            lock.lock();
            CommonUtils.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}