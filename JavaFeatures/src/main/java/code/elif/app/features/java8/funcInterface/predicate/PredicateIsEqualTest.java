package code.elif.app.features.funcInterface.predicate;

import java.util.function.Predicate;

public class PredicateIsEqualTest {
    public static void main(String[] args) {
        Predicate<String> isApple = Predicate.isEqual("Apple");
        System.out.println(isApple.test("aPPLE")); // false
        System.out.println(isApple.test("Apple")); //true
    }
}
