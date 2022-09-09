package code.elif;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {

    private static final int N = 10000000;

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(N);


        ArrayList<Integer> integers = new ArrayList<Integer>();

        System.out.println(  integers.toArray().length);


        int first = 0;
        int last = N;
        int guess;

        System.out.println("number is " + number);
        while (first < last) {
            guess = (first + last) / 2;
            if (number > guess) {
                first = guess + 1;
            } else {
                last = guess;
            }
            System.out.println("Guess is " + guess);
            if (number == guess) {
                return;
            }
        }
    }
}
