package code.elif.stream;

import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        lazyStreamLoading();

    }

    private static void lazyStreamLoading() {
        Stream<Integer> integerStream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * 2;
                });

        System.out.println(integerStream.toList());
    }

    private static void lazyStream() {
        Stream<Integer> integerStream = Stream.of(1);
        integerStream.map(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i * 2;
        });

        System.out.println(integerStream);
    }
}