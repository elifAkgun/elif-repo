package code.elif.app.features.java10.optional;

import java.util.Optional;
import java.util.stream.Stream;

//Example of orElseThrow method in Optional class.
public class OptionalOrElseThrow {
    public static void main(String[] args) {
        OptionalOrElseThrow optionalOrElse = new OptionalOrElseThrow();
        String largeNameFruit = optionalOrElse.findLargeNameFruit();
        System.out.println("Fruit word is : " + largeNameFruit);
    }

    public String findLargeNameFruit() {
        Optional<String> largeNameFruit = searchLargeNameFruit();
        //Avoid
        // if (largeNameFruit.isPresent()) {
        //     return largeNameFruit.get();
        // }
        // throw new NoSuchElementException("Fruit not found...");
        return largeNameFruit.orElseThrow();
    }

    private Optional<String> searchLargeNameFruit() {
        return Stream.of("Apple", "Strawberry", "Pineapple")
                .filter(s -> s.length() >= 50)
                .findAny();
    }
}
