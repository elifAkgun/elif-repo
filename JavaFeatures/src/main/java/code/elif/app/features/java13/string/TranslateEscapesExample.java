package code.elif.app.features.java13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranslateEscapesExample {

    public static void main(String[] args) throws IOException {

        Stream<String> lines = Files.lines(Path.of("src/main/java/code/elif/app/features/java13/EscapeSequence.txt"));

        Map<Integer, List<String>> collect =
                lines.filter(Predicate.not(String::isBlank))
                        .map(String::translateEscapes)
                .collect(Collectors.groupingBy(String::length));

        System.out.println(collect);

    }
}
