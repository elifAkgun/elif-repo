package code.elif.thread.virtual.synchronization;

import code.elif.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SynchronizationApp {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizationApp.class);

    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        demo(Thread.ofVirtual());
        CommonUtils.sleep(Duration.ofSeconds(1));
        logger.info("ListSize: {}", list.size());
    }

    public static void demo(Thread.Builder threadBuilder) {
        for (int i = 0; i < 500; i++) {
            threadBuilder.start(()-> {
                logger.info("InMemory tasks are started...");
                for (int j = 0; j < 20; j++) {
                    inMemoryTask();
                }
                logger.info("InMemory tasks are finished...");
            });
        }
    }

    private static synchronized void inMemoryTask() {
        list.add(1);
    }
}
