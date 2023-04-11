package code.elif;

import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {

    private static final int N = 10000000;

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(N);


        ArrayList<Integer> integers = new ArrayList<>();

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


class Example {
    public static void main(String[] args) throws KeyStoreException, NoSuchFieldException, IllegalAccessException {
        KeyStore ks = KeyStore.getInstance("jceks");
        Field f = ks.getClass().getDeclaredField("keyStoreSpi");
        f.setAccessible(true);

        System.out.println(f.get(ks));
    }
}

