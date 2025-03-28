package code.elif.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class Tasks {

    private static final Logger logger = LoggerFactory.getLogger(Tasks.class);

    public static void ioIntensive(long intensive) {
        logger.info("ioIntensive is started {}", intensive);
        CommonUtils.sleep(Duration.of(intensive, ChronoUnit.MILLIS));
        logger.info("ioIntensive is finished {}", intensive);
    }

    public static void cpuIntensive(long intensive) {
        long currented = System.currentTimeMillis();
        logger.info("ioIntensive is started {} tasks", intensive);
        CommonUtils.timer(() -> findFibonacci(intensive));
        long l = (System.currentTimeMillis() - currented) / 1000;
        logger.info("ioIntensive is finished {} tasks with in {} seconds", intensive, l);
    }

    private static long findFibonacci(long input) {
        if (input < 2)
            return 1;
        else
            return findFibonacci(input - 1) + findFibonacci(input - 2);
    }
}
