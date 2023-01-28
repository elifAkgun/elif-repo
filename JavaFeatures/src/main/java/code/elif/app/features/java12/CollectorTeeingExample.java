package code.elif.app.features.java12;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorTeeingExample {
    public static void main(String[] args) {
        makeSentence();

        getAverage();
    }

    private static void getAverage() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        double collect = integerStream
                .collect(Collectors.teeing(
                        Collectors.summingDouble(number -> number),
                        Collectors.counting(),
                        (sum, count) -> sum / count
                ));

        System.out.println(collect);
    }

    private static void makeSentence() {
        List<String> words = List.of("Hello", "this", "is", "an", "example", "for", "using", "teeing", "method!");

        Statistic statistic = words.stream()
                .collect(Collectors.teeing(Collectors.joining(" "),
                        Collectors.counting(),
                        Statistic::new));

        System.out.println(statistic);
    }
}

@Data
@AllArgsConstructor
class Statistic {

    private String collectedData;
    private long processed;
}
