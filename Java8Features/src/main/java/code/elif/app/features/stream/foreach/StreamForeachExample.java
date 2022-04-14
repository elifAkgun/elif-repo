package code.elif.app.features.stream.foreach;

import java.util.Arrays;
import java.util.List;

public class StreamForeachExample {
    public static void main(String[] args) {
        processByForeach();
    }

    private static void processByForeach() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
        list.stream().forEach(s -> System.out.println(s));

        list.stream().forEach(System.out::println);
    }
}

