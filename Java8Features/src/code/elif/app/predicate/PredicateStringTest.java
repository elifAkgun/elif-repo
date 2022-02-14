package code.elif.app.predicate;

import java.util.function.Predicate;

public class PredicateStringTest {

    public static void main(String[] args) {

        String[] fruits = {"Apple", "Pineapple", "Strawberry", "BlueBerry", "Peach", "Banana"};

        Predicate<String> isFirstLetterStartWithP = s -> s.startsWith("P");

        System.out.println("Fruits name start with P");
        for (String fruit : fruits) {
            if (isFirstLetterStartWithP.test(fruit)) {
                System.out.println(fruit);
            }
        }
    }
}