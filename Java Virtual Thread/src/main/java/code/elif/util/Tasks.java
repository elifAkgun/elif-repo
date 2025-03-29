package code.elif.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class Tasks {

    private static final Logger logger = LoggerFactory.getLogger(Tasks.class);

    public static void ioIntensive(long intensive, String description) {
        logger.info("ioIntensive is started {}", description);
        CommonUtils.sleep(Duration.of(intensive, ChronoUnit.MILLIS));
        logger.info("ioIntensive is finished {}", description);
    }

    public static void cpuIntensive(long intensive) {
        findFibonacci(intensive);
    }

    private static long findFibonacci(long input) {
        if (input < 2)
            return 1;
        else
            return findFibonacci(input - 1) + findFibonacci(input - 2);
    }
}
