package code.elif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class BinarySearch {

    private static final int N = 10000000;
    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(N);

        int first = 0;
        int last = N;
        int guess;

        logger.info("number is {}", number);
        while (first < last) {
            guess = (first + last) / 2;
            if (number > guess) {
                first = guess + 1;
            } else {
                last = guess;
            }
            logger.info("Guess is {}", guess);
            if (number == guess) {
                return;
            }
        }
    }
}

