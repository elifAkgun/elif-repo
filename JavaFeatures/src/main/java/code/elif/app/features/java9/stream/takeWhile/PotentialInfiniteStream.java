package code.elif.app.features.java9.stream.takeWhile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PotentialInfiniteStream {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(2,
                        n -> 33554432 >= n,
                        n -> n + n)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void usingTakeWhileFunction() {
        List<Integer> list = Stream.iterate(2, n -> n + n)
                .takeWhile(n -> 33554432 >= n)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void usingLimitFunction() {
        List<Integer> list = Stream.iterate(2, n -> n + n)
                .limit(25)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void usingIterateFunction() {
        List<Integer> list = Stream.iterate(2, n -> 33554432 >= n, n -> n + n)
                .collect(Collectors.toList());
        System.out.println(list);
    }


}
