package code.elif.mono;

import reactor.core.publisher.Mono;

public class MonoExample {

    public static void main(String[] args) {
        // simpleMono();
        // onErrorCase();

        successfulCase();

    }

    private static void successfulCase() {
        Mono<Integer> mono = Mono.just("Apple")
                .map(s -> s.length());


        mono.subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed"));
    }

    private static void onErrorCase() {
        Mono<Integer> mono = Mono.just("Apple")
                .map(s -> s.length())
                .map(length -> length / 0);


        mono.subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed"));
    }

    private static void simpleMono() {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i -> System.out.println("Received : " + i));
    }
}
