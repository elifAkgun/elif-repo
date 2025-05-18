package code.elif.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumOperation {

    private static final Logger logger = LoggerFactory.getLogger(SumOperation.class);

    public static void main(String[] args) {
        int totalSum = totalSum(5);

        logger.info(String.valueOf(totalSum));
    }

    private static int totalSum(int i) {
        if (i == 1) {
            return 1; // base condition
        }
        return i + totalSum(i - 1);
    }
}
