package code.elif.app.features.java12.string;

import java.util.List;
import java.util.stream.Collectors;

public class TransformExample {

    public static void main(String[] args) {
        withoutTransform();
    }


    private static void withoutTransform() {
        var joke = "the only fruit i like is apple";
        //Expected output - "Only Fruit I Like Is Apple...."
        var result = upperCase(dropFirstWord(joke)).concat("...");
        System.out.println(result);
    }

    private static void withTransform() {
        var joke = "the only fruit i like is apple";
        var result = joke.transform(TransformExample::dropFirstWord)
                .transform(TransformExample::upperCase)
                .concat("...");

        System.out.println(result);
    }

    private static String dropFirstWord(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .skip(1)
                .collect(Collectors.joining(" "));
    }


    private static String upperCase(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
