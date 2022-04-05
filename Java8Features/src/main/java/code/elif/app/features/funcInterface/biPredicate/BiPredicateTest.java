package code.elif.app.features.funcInterface.biPredicate;

import java.util.function.BiPredicate;

public class BiPredicateTest {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BiPredicate<Integer, Integer> isTotalEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println(isTotalEven.test(10,20));
        System.out.println(isTotalEven.test(15,20));
    }
}
