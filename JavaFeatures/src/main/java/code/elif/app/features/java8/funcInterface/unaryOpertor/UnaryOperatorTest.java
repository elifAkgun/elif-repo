package code.elif.app.features.funcInterface.unaryOpertor;

import java.util.Random;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

    public static void main(String[] args) {
        UnaryOperator<Integer> addRandomValue = (x) -> {
            Random random = new Random();
            return x + random.nextInt(100);
        };

        System.out.println(addRandomValue.apply(10));
    }
}
