package code.elif.app.funcInterface.biFunction;

import java.util.function.BiFunction;

public class BiFunctionTest {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(4,6));
        System.out.println(multiply.apply(2,5));
    }
}
