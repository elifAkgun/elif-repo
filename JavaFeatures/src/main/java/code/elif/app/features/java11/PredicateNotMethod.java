package code.elif.app.features.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateNotMethod {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/main/java/code/elif/app/features/java11/text.txt"));

        usingFilterLambdaExpression(lines);
        usingFilterMethodReference(lines);
        usingFilterPredicateNot(lines);
    }

    private static void usingFilterLambdaExpression(Stream<String> lines) throws IOException {
        List<String> nonBlankLines = lines.filter(line -> !line.isBlank())
                .collect(Collectors.toList());
        System.out.println(nonBlankLines);
    }

    private static void usingFilterMethodReference(Stream<String> lines) throws IOException {
        List<String> nonBlankLines = lines.filter(((Predicate<String>) String::isBlank).negate())
                .collect(Collectors.toList());
        System.out.println(nonBlankLines);
    }

    private static void usingFilterPredicateNot(Stream<String> lines) throws IOException {
        List<String> nonBlankLines = lines.filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(nonBlankLines);
    }
}
