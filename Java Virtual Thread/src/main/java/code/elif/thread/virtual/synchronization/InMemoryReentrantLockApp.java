package code.elif.thread.virtual.synchronization;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryReentrantLockApp {

    private static final Lock lock = new ReentrantLock(); // Fairness varsayılan olarak false

    private static final Logger logger = LoggerFactory.getLogger(PinningThreadApp.class);

    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        demo(Thread.ofVirtual());
        CommonUtils.sleep(Duration.ofSeconds(1));
        logger.info("ListSize: {}", list.size());
    }

    public static void demo(Thread.Builder threadBuilder) {
        for (int i = 0; i < 50; i++) {
            threadBuilder.start(()-> {
                logger.info("InMemory tasks are started...");
                for (int j = 0; j < 20; j++) {
                    inMemoryTask();
                }
                logger.info("InMemory tasks are finished...");
            });
        }
    }

    private static void inMemoryTask() {
        try {
            lock.lock();
            list.add(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
