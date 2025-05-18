package code.elif.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recursive {
    private static final Logger logger = LoggerFactory.getLogger(Recursive.class);

    public static void main(String[] args) {
        int fibonacci = fibonacci(9);
        logger.info(String.valueOf(fibonacci));

        int factorial = factorial(5);
        logger.info(String.valueOf(factorial));
    }

    private static int fibonacci(int x) {
        if (x <= 2) {
            return x - 1;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }

    private static int factorial(int x) {
        if (x == 1) {
            return x;
        } else {
            return x * factorial(x - 1);
        }
    }
}
