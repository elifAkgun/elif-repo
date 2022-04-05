package code.elif.app.features.funcInterface.binaryOperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Integer> calculateValue = (x,y)-> x+y;
        System.out.println(calculateValue.apply(10,20));
    }
}
