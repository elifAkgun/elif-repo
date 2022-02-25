package code.elif.app.funcInterface.predicate;

import java.util.function.Predicate;

/**
 * This class is used for examples of predicate usage.
 * In this example, we covered predicate joining.
 */

public class PredicateIntegerTest {
    public static void main(String[] args) {

        int[] x = {0, 5, 10, 15, 20, 25, 30};

        Predicate<Integer> p1 = i -> i > 10;
        Predicate<Integer> p2 = i -> i % 2 == 0;

        m1(p1, x);
        m1(p2, x);
        m1(p1.negate(), x);
        m1(p1.and(p2), x);
        m1(p1.or(p2), x);
    }

    public static void m1(Predicate<Integer> p, int[] array) {
        for (int a : array) {
            if (p.test(a)) {
                System.out.print(a + ", ");
            }
        }
        System.out.println();
    }
}
